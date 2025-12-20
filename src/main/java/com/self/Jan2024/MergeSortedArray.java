package com.self.Jan2024;

import scala.Int;

import java.util.*;
import java.util.stream.IntStream;

public class MergeSortedArray {
    public int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (j >= 0){
            if(nums2[j] > nums1[i]){
                nums1[k--] = nums2[j--];
            }
            else{
                nums1[k--] = nums1[i--];
            }
        }
        return nums1;
    }

    public int removeElement(int[] nums, int val) {
        int index =0;
        for(int i = 0; i < nums.length -1; i++){
            if(nums[i] != val){
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }

    public int removeDuplicates(int[] nums) {
        int i = 1;
        for(int x = 1; x <= nums.length - 1; x++){
            if(nums[x] != nums[x-1]){
                nums[i] = nums[x];
                i = i+1;
            }
        }
        return i;
    }

    public int removeDuplicates1(int[] nums) {
        int i = 2;
        for(int x = 2; x <= nums.length - 1; x++){
            if(nums[x] != nums[x-2
                    ]){
                nums[i] = nums[x];
                i = i+1;
            }
        }
        return i;
    }

    public void rotate(int[] nums, int k) {
        int split = nums.length;
        k %= split;
        reverseArray(nums, split-k,split-1);
        reverseArray(nums,0, split-k-1);
        reverseArray(nums, 0, split-1);

    }

    private void reverseArray(int[] nums, int startindex, int endIndex){
        while (endIndex > startindex){
           int temp = nums[startindex];
           nums[startindex] = nums[endIndex];
           nums[endIndex] = nums[startindex];
           startindex++;
           endIndex--;
        }
    }

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int midPoint = (int) Math.floor(nums.length/2);
        return nums[midPoint];
    }

    public int maxProfit(int[] prices) {
        int profit = 0;
        for(int i =0; i <= prices.length-2; i++){
           if(prices[i+1] - prices[i] > 0){
               profit = profit + (prices[i+1] - prices[i]);
           }
        }
        return profit;
    }

    public static int equalizeArray(List<Integer> arr) {
        // Write your code here
        HashMap<Integer, Integer> integerIntegerHashMap = new HashMap<>();
        Collections.sort(arr);
        for(int x = 0; x < arr.size()-1; x++){
            if(!integerIntegerHashMap.containsKey(arr.get(x))){
                 integerIntegerHashMap.put(arr.get(x),0);
            }
            else{
                integerIntegerHashMap.put(arr.get(x),integerIntegerHashMap.get(arr.get(x)) + 1);
            }
        }
        return 0;
    }

    public boolean canJump(int[] nums) {

        int hasReached = 0;

        for(int i = 0; i <= nums.length -1; i++){
           if(i == hasReached){
               hasReached = i + nums[i] ;
           }

        }
         if(hasReached >= nums.length){
             return true;
         }
         else return false;
    }

    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length-1;

       while(right > left){
           maxArea = Math.max(maxArea,Math.min(height[left],height[right])*(right-left));
           if(height[left] > height[right]){
               right--;
           }
           else{
               left++;
           }
       }
        return maxArea;
    }

    public int[] productExceptSelf(int[] nums) {
        int productWithoutZero =1;
        int numZeros = 0;
        for(int i =0; i <= nums.length-1; i++){
            if(nums[i] != 0){
                productWithoutZero = productWithoutZero*nums[i];
            }
            else {
                numZeros++;
                if(numZeros > 1){
                    productWithoutZero = 0;
                }
            }
        }
        int[] ints = new int[nums.length];
        for(int i =0; i <= nums.length-1; i++){
            if(productWithoutZero != 0) {
                if (nums[i] == 0) {
                    ints[i] = productWithoutZero / nums[i];
                }
                else {
                    ints[i] = 0 * productWithoutZero / nums[i];
                }
            }
            else {
                ints[i] = 0;
            }
        }
        return ints;
    }
    public void nextPermutation(int[] nums) {
        int idx1 = -1;
        for(int i = nums.length-2;i >= 0;i--){
            if(nums[i] < nums[i+1]){
                idx1 = i;
                break;
            }
        }
        if(idx1 <0){
            Arrays.sort(nums);
        }
        else {
            int idx2 =0 ;
            for(int i = nums.length-1; i > idx1 ;i--){
                if(nums[i]>nums[idx1]){
                    idx2 = i;
                }
            }
            swap(nums, idx1, idx2);
            Arrays.sort(nums, idx1+1, nums.length-1);
        }
    }

    private void swap(int[] nums, int idx1, int idx2) {
        int temp = nums[idx2];
        nums[idx2] = nums[idx1];
        nums[idx1] = temp;
    }

    public String solve(int A) {
        int result = 1;
        while(A > 0){
            result = result*A;
            A--;
        }
        return Integer.toString(result);
    }

    public void moveZeroes(int[] nums) {
       int nonZeros = 0;
        for( int i =0; i <= nums.length-1; i++) {
            if(nums[i] !=0){
                nums[nonZeros] = nums[i];
                nonZeros++;
            }
        }
        for(int y = nonZeros; y <= nums.length-1; y++){
            nums[y] = 0;
        }
    }

    public int characterReplacement(String s, int k) {
        char[] charArray = s.toCharArray();
        int longestSubString = 0;
        int startString = 0;
        int ac = k;
        int endString = 0;
        while(endString <= charArray.length-1 && k >= 0){
            if(charArray[startString] == charArray[endString]){
                endString++;
                if((endString-startString)> longestSubString){
                    longestSubString = endString-startString;
                }
            }
            else{
                if(k>0){
                    k--;
                    endString++;
                    if((endString-startString)> longestSubString){
                        longestSubString = endString-startString;
                    }
                }
                else{
                    if((endString-startString)> longestSubString){
                        longestSubString = endString-startString;
                    }
                    startString++;
                    k =ac;
                    endString = startString;
                }
            }
        }
        return longestSubString;
    }

    //


    public static void main(String[] args) {
        MergeSortedArray mergeSortedArray = new MergeSortedArray();
       // Arrays.stream(mergeSortedArray.merge(new int[]{1,2,3,0,0,0},3, new int[]{2,5,6},3)).forEach(System.out::println);
//        mergeSortedArray.productExceptSelf(
//                new int[]{1,2,3,4});
        //mergeSortedArray.moveZeroes(new int[]{6,1,0,3,12});
        List<String> arrayList = new ArrayList<>();
        int[] ints = new int[5];
        String[] se  = new String[5];
        String s = new String();
        List<HashMap> lh = new ArrayList<>();
        HashMap<String, Integer> stringIntegerHashMap = new HashMap<>(10);
        //  System.out.println(mergeSortedArray.characterReplacement("ABBB",1));
        mergeSortedArray.nextPermutation(new int[]{3,1,2});
    }
}
