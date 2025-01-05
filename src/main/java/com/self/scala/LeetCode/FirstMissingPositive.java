package com.self.scala.LeetCode;

import scala.Int;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> objects = new HashSet<>();
        for(int x : nums){
            objects.add(x);
        }
        int i =1;
        while(i<=nums.length){
            if(objects.contains(i)){
                i++;
            }
            else{
                return i;
            }
        }
        return nums.length+1;
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int index = 0;
        int availableGas = 0;
        int requiredGas =0;
        for (int i = 0; i <= gas.length - 1; i++) {
            availableGas = availableGas + gas[i] - cost[i];
            if(availableGas < 0){
                requiredGas  =requiredGas + availableGas;
                availableGas = 0;
                index = i;
            }
        }
        if (availableGas + requiredGas>= 0) {
            return index-1;
        }
            return -1;
        }
    public int lengthOfLastWord(String s) {
        String s1 = s.trim();
        int count = 0;
        int length = s1.length()-1;
        while(length > 0 && s1.charAt(length) != ' '){
            count =count +1;
            length--;
        }
        return count;
    }

    public boolean isHappy(int n) {
        // Create a set to keep track of the numbers that have already been seen
        Set<Integer> seen = new HashSet<>();

        // Loop until either n becomes 1 (in which case n is a happy number) or n is seen again (in which case n is not a happy number)

        while (n != 1 && !seen.contains(n)) {
            // Add n to the set of seen numbers
            seen.add(n);

            // Compute the sum of the squares of the digits of n
            int sum = 0;
            while (n != 0) {
                int digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }

            // Update n with the sum of the squares of its digits

            n = sum;
        }

        // If n is 1, it is a happy number; otherwise, it is not
        return n == 1;
    }

    public int longestConsecutive(int[] nums) {

        Arrays.sort(nums);
        int maxLen = 1;
        int counter = 1;
        if( nums.length ==1){
            maxLen =1;
        }
        for(int i = 1; i <= nums.length-1;i++ ){
            if((nums[i] - nums[i-1]) == 1){
                    counter = counter + 1;
            }
            else{
                if(counter > maxLen){
                    maxLen = counter;
                }
                if(nums[i] != nums[i-1]) {
                    counter = 1;
                }
            }
        }
        if(counter > maxLen){
            maxLen = counter;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] num = new int[]{1,2,3,4,5};
        int[] cost =  new int[]{3,4,5,1,2};
        FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
        System.out.println(firstMissingPositive.longestConsecutive(new int[]{100,4,200,1,3,2}));
    }
}
