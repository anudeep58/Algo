package com.self.Jul2023;

import scala.Int;

import java.util.*;

public class TwoSums {
    public int[] twoSum(int[] nums, int target) {
        Hashtable<Integer, Integer> hashtable = new Hashtable<Integer, Integer>();
        for(int i = 0; i <= nums.length-1; i++){

            int valueToFind = target - nums[i];
            if(hashtable.containsKey(valueToFind)){
                return new int[]{i,hashtable.get(valueToFind)};
            }
            else{
                hashtable.put(nums[i],1);
            }
        }
        return null;
    }
    public int[] twoSum2(int[] nums, int target) {
        int leftPointer = 0;
        int rightPointer = nums.length-1;
       while(rightPointer>leftPointer){
           if(nums[leftPointer]+nums[rightPointer] == target){
               break;
           }
           if(nums[leftPointer]+nums[rightPointer] > target){
               rightPointer --;
           }
           else {
               leftPointer ++;
           }
       }
        return new int[]{leftPointer+1,rightPointer+1};
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        char[] magazineCharArray = magazine.toCharArray();
        HashMap<Character, Integer> magazineHashMap = new HashMap<Character,Integer>();
        for(int i =0;i <= magazineCharArray.length-1;i++){
                magazineHashMap.put(magazineCharArray[i],magazineHashMap.
                        getOrDefault(magazineCharArray[i],0)+1);
        }
        char[] ransomCharArray = ransomNote.toCharArray();
        for(int i =0; i <= ransomCharArray.length-1;i++){
            if(magazineHashMap.containsKey(ransomCharArray[i])){
                if(magazineHashMap.get(ransomCharArray[i])>0){
                    magazineHashMap.put(ransomCharArray[i],magazineHashMap.get(ransomCharArray[i])-1);
                }
                else{
                    return false;
                }
            }
            else {
                return false;
            }
        }
        return true;
    }

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n !=1 ){
            int sum =0;
            int current =n;
            while(current > 0){
                sum = sum + (current%10)*(current%10);
                current = current/10;
            }
            if(!set.add(sum)){
                return false;
            }
            n = sum;
        }
        return true;
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        for(int i =0; i <= nums.length-1;i++){
            int start = nums[i];
            while(i+1<nums.length && nums[i+1] - nums[i]==1){
                i++;
            }
            int end = nums[i];
            if(start!=end){
                list.add("\""+start+"->"+end+"\"");
            }
            else {
                list.add("\""+start+"\"");
            }

        }
        return list;
    }

//    public int[][] merge(int[][] intervals) {
//        int[][] list = new int[intervals.length][2];
//        for(int i = 0;i < intervals.length;i++){
//            ifintervals[i][1] < intervals[i+1][0]
//        }
//    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};
        TwoSums twoSums = new TwoSums();
        System.out.println(twoSums.canConstruct("dehifb","hhjdgjbhahaagihhhhhajjibjffhijehda"));
    }

}
