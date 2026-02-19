package com.self.Java26;

import scala.Int;

import java.util.HashMap;
import java.util.Map;

public class PreFixSumSolutions {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> preFixmap = new HashMap<>();
        preFixmap.put(0,-1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum+nums[i];
            int remainder;
            if (k != 0) {
                remainder = sum % k;
            } else {
                remainder = sum; // when k == 0
            }
            if(preFixmap.containsKey(remainder)){
                if (i - preFixmap.get(remainder) >= 2) {
                    return true;
                }
            }
            else {
                preFixmap.put(remainder, i);
            }
        }
        return false;
    }

    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> prefixSum = new HashMap<>();
        int currSum = 0;
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            currSum = currSum + nums[i];

            if(currSum==k){
                maxLen = maxLen+1;
            }

            if (prefixSum.containsKey(currSum-k)){
                maxLen = Math.max(maxLen, i - prefixSum.get(currSum-k));
            }
            prefixSum.putIfAbsent(currSum, i);

        }
    return maxLen;
    }

    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> prefixmap = new HashMap<>();
        int currentSum = 0;
        int subArrayCount = 0;
        prefixmap.put(0,1);
        for (int i = 0; i < nums.length; i++) {
            currentSum = currentSum + nums[i];
            int reminder = currentSum%k;
            if(reminder < 0){
                reminder += k;
            }

            if(prefixmap.containsKey(reminder)){
                subArrayCount+= prefixmap.get(reminder);
            }

            prefixmap.put(reminder, prefixmap.getOrDefault(reminder,0)+1);

        }
        return subArrayCount;
    }

    public static void main(String[] args) {

    }
}
