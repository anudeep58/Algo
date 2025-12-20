package com.self.java25;

import com.sun.scenario.effect.Brightpass;

import java.util.*;

public class HourGlass {

    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> occuranceHashMap = new HashMap<>();
        occuranceHashMap.put(0,1);
        int count = 0, sum =0;
        for(int i = 0; i <= nums.length - 1; i++){

            sum = sum + nums[i];

            if(occuranceHashMap.containsKey(sum-k)){
                count = count + occuranceHashMap.get(sum-k);
            }

            if(occuranceHashMap.containsKey(sum)){
                occuranceHashMap.put(sum ,occuranceHashMap.get(sum) + 1);
            }
            else{
                occuranceHashMap.put(sum,1);
            }

        }
        return count;
    }

    public static int numSubarraysWithSum(int[] nums, int goal) {
        int left = 0, right =0, sum =0, count =0;
        sum = sum + nums[left] ;
        while (right <= nums.length-1){

            if(goal == sum){
                count++;
            }
            if(sum <= goal){
                sum = sum + nums[right];
                right++;
            }
            if(sum > goal){
                sum = sum - nums[left];
                left++;
            }
        }
        return count;
    }

    public static int hourglassSum(List<List<Integer>> arr) {
        // Write your code here
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < arr.size()-1; i++) {
            for (int j = 0; j < arr.get(i).size()-1; j++) {
                if(i+2 < arr.size() && j+2 < arr.get(i).size()){
                    int sum = arr.get(i).get(j)+ arr.get(i).get(j+1) + arr.get(i).get(j+2) +arr.get(i+1).get(j+1) +
                            arr.get(i+2).get(j)+ arr.get(i+2).get(j+1) + arr.get(i+2).get(j+2);
                    arrayList.add(sum);
                }
            }

        }
        Integer max = Collections.max(arrayList);
        return max;
    }

    public static void minimumBribes(List<Integer> q) {
        // Write your code here
        int totalBribes =0;
        for (int i = 0; i < q.size()-1; i++) {
            int bribe = 0;
            for (int j = i; j < q.size(); j++)
            if(bribe > 2){
                System.out.println("Too chaotic");
                break;
            }
            totalBribes = totalBribes+bribe;
        }

            System.out.println(totalBribes);


    }
    public int longestOnes(int[] nums, int k) {
        int left = 0, max =0;
        for(int right =0 ; right < nums.length ; ++right){
            if(nums[right] == 0){
                k--;
            }
            while(k<0){
                if(nums[left] == 0){
                    k++;
                }
                left++;
            }
            max = Math.max(max, right-left+1);
        }
        return max;
    }

    public int maxConsecutiveAnswers(String answerKey, int k) {
        int left =0, max =0, trueCount =0, falseCount = 0;
        for (int right = 0; right < answerKey.length()-1; right++) {
            if(answerKey.charAt(right) == 'T'){
                falseCount++;
            }
            if(answerKey.charAt(right) == 'F'){
                trueCount++;
            }
            while(falseCount > k && trueCount > k){
                if(answerKey.charAt(left) == 'T'){
                    falseCount--;
                }
                else {
                    trueCount--;
                }
                left++;
            }
            max = Math.max(max, right-left+1);
        }
        return max;
    }

//    public int minOperations(int[] nums) {
//        HashSet<Integer> numsUniqueHS = new HashSet<>();
//        for (int i = 0; i < nums.length-1; i++) {
//            numsUniqueHS.add(nums[i]);
//        }
//        Integer[] numsUnique = numsUniqueHS.stream().toArray(Integer[]::new);
//        Arrays.sort(numsUnique);
//        int left = 0;
//        for (int right = 0; right < numsUnique.length; right++) {
//            int size = numsUnique[right] + numsUnique.length -1;
//            while (numsUnique[])
//        }
//
//    }

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int[][] intNew = new int[intervals.length][2];
        int left = 0, intNewPointer = 0;
        for (int right = 1; right < intervals.length; ++right) {
            if(left <=right){
            int max = intervals[left][1];
            while(intervals[left][1] > intervals[right][0] && right < intervals.length){
                max = Math.max(max, intervals[right][1]);
                right++;
            }
            intNew[intNewPointer][0] = intervals[left][0];
            intNew[intNewPointer][1] = max;
            left = right+1;
            intNewPointer++;
        }
        }
        return intNew;
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        int left = 0, right = arr.length - k;
        while (left < right) {
            int midpoint = left + (right - left) / 2; // same as (left + right) / 2
            if (x - arr[midpoint] > arr[midpoint + k] - x) {
                left = midpoint + 1;
            }
            else {
                right = midpoint;
            }
        }

        List<Integer> result = new ArrayList<>(k);
        for (int i = left; i < left + k; i++) {
            result.add(arr[i]);
        }
        return result;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length -3; i++) {
            for (int j = i+1; j < nums.length -2; j++) {
                int left = j+1, right = nums.length-1;
                while (left < right){
                    if(nums[i]+nums[j]+ nums[right]+nums[left] == target){
                        List<Integer> subList = new ArrayList<>();
                        subList.add(nums[i]);
                        subList.add(nums[j]);
                        subList.add(nums[right]);
                        subList.add(nums[left]);
                        result.add(subList);
                        left++;right--;
                    }
                    else {
                        if(nums[i]+nums[j]+ nums[right]+nums[left] > target){
                            right--;
                        }
                        else {
                            left++;
                        }
                    }
                }
            }
        }
        return result;
    }

    public static String compress(String s){
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = s.toCharArray();
        int left = 0;
        for (int i = 0; i < chars.length; i++) {
            if(chars[left] != chars[i]){
                stringBuilder.append(chars[left]).append(i-left);
                left = i;
            }
        }
        return stringBuilder.toString();
    }
// dbs19
    public static void main(String[] args) {
//        List<List<Integer>> arr = new ArrayList<>();
//        List<Integer> line1 = Arrays.asList(1, 1 ,1, 0, 0, 0);
//        List<Integer> line2 = Arrays.asList(0, 1 ,0, 0, 0, 0);
//        List<Integer> line3 = Arrays.asList(1, 1 ,1, 0, 0, 0);
//        List<Integer> line4 = Arrays.asList(0, 0 ,2, 4, 4, 0);
//        List<Integer> line5 = Arrays.asList(0, 0 ,0, 2, 0, 0);
//        List<Integer> line6 = Arrays.asList(0, 0 ,1, 2, 4, 0);
//        arr.add(line1);
//        arr.add(line2);
//        arr.add(line3);
//        arr.add(line4);
//        arr.add(line5);
//        arr.add(line6);
//        System.out.println(hourglassSum(arr));
        //numSubarraysWithSum(new int[]{1,0,1,0,1}, 4);
        //System.out.println(compress("abcabbbccaabd"));
        new HourGlass().fourSum(new int[]{1,0,-1,0,-2,2}, 0).forEach(System.out::println);
        //new HourGlass().findClosestElements(new int[]{1,2,3,4,5}, 4, 3);
    }
}
