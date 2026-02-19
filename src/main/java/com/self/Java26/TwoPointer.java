package com.self.Java26;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoPointer {
    public int numRescueBoats(int[] people, int limit) {
        int numberOfBoats = 0;

        Arrays.sort(people);
        int left = 0, right = people.length-1;
        while (left <= right){
            int currentSum=0;
            currentSum = people[left]+people[right] ;
            if (left==right) {
                currentSum = people[right];
            }
            if(currentSum <= limit){
                numberOfBoats++;
                left++;
                right--;
            } else {
                numberOfBoats++;
                right--;
            }

        }
        return numberOfBoats;
    }

    public int removeDuplicates(int[] nums) {
        int left =1;
        for (int i = 1; i <= nums.length-1; i++) {
            if(nums[i] != nums[i+1]){
                nums[left] = nums[i+1];
                left++;
            }
        }
        return left;
    }

    public int numSubseq(int[] nums, int target) {
        int number = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            number += calculateSubSeq(nums, i, target);
        }
        return number;
    }

    private int calculateSubSeq(int[] nums, int i, int target) {
        int left = i;
        int right = nums.length;
        int count = 0;
        while (right > left){
            if(nums[left]+nums[right] <= target){
                int power = right-left;
                count += (int)Math.pow(2, power);
                break;
            }
            right--;
        }
        return count;
    }

    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> result = new ArrayList<>();
        int size = arr.length-1;
        for (int i = size; i >= 0 ; i--) {
            int maxIndex =  findmax(arr, i);

            if(maxIndex != 0){
                flip(arr,maxIndex);
                result.add(maxIndex+1);
            }
            flip(arr, i-1);
            result.add(i);
        }
        return result;
    }

    private void flip(int[] arr, int maxIndex) {
        int left =0; int right = maxIndex;
        while (left < right){
            int temp = arr[right];
            arr[right] = arr[left];
            arr[left] = arr[temp];
            left++;
            right--;
        }
    }

    private int findmax(int[] arr, int size) {
        int maxIndex = 0;
        for (int i = 0; i <= size; i++) {
            if(arr[i] > arr[maxIndex]){
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public int threeSumMulti(int[] arr, int target) {
        int result = 0;
        final int MOD = 1_000_000_007;
        for (int i = 0; i < arr.length-1; i++) {
            int left = i+1;
            int right = arr.length-1;
            while (left < right){
                if (arr[i] + arr[left] + arr[right] == target){
                    if(arr[left] == arr[right]){
                        int length = right-left+1;
                        result+=length*(length-1)/2;
                        result%=MOD;
                        break;
                    }
                    else {
                        int leftVal = arr[left];
                        int rightVal = arr[right];
                        int leftCount = 0;
                        int rightCount = 0;
                        while (left < right &&  arr[left]== leftVal){
                            leftCount++;
                            left++;
                        }
                        while (left < right && arr[right] == rightVal){
                            rightCount++;
                            right--;
                        }
                        result+= leftCount*rightCount;
                        result%=MOD;
                    }
                }
            }
        }
        return result;
    }

    public String reverseVowels(String s) {
        char[] word = s.toCharArray();
        int left = 0, right = s.length()-1;
        String vowel = "aeiouAEIOU";
        while (left < right){
            while (left < right && vowel.indexOf(s.charAt(left)) == -1){
                left++;
            }
            while (left < right && vowel.indexOf(s.charAt(right)) == -1){
                right--;
            }

            char temp = word[left];
            word[left] = word[right];
            word[right] = temp;

            left++;
            right--;
        }
        return new String(word);
    }

    public static void main(String[] args) {
        int[] arr =  new int[]{3,5,3,4};
        int[] arr1 = new int[]{0,0,1,1,1,2,2,3,3,4};
        TwoPointer twoPointer = new TwoPointer();
//        System.out.println(new TwoPointer().numRescueBoats(arr, 5));
        System.out.println(twoPointer.removeDuplicates(arr1));
    }
}
