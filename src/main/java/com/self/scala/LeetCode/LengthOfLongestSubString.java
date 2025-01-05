package com.self.scala.LeetCode;

import scala.Array;
import scala.Int;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LengthOfLongestSubString {

    public int removeElement(int[] nums, int val) {
        int index = 0;
        for(int i =0; i <= nums.length - 1; i++){
            if(nums[i] != val){
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }

    public String reverseWords(String s) {
        String[] s1 = s.trim().split(" ");
        StringBuilder sF = new StringBuilder();
        for(int i =s1.length-1; i >= 0 ; i--){
            if(!s1[i].equals("")) {
                sF.append(s1[i].trim());
            }
        }
        return sF.toString();
    }

    public int[] rotate(int[] nums, int k) {
        int[] myIntArray = new int[nums.length];
        for(int i =0; i <= nums.length -1; i++){
            int pointer = nums.length - k +i;
            if(pointer < nums.length){
                myIntArray[i] = nums[pointer];
            }
            else{
                myIntArray[i] = nums[pointer - nums.length];
            }
        }
        nums = myIntArray;
        return nums;
    }

    public boolean canJump(int[] nums) {
        int Reach=0;
        for(int i=0; i<nums.length; i++){
             if(Reach<i){
                return false;
            }
            if(Reach<i+nums[i]){
                Reach=i+nums[i];
            }
        }
        return true;
    }
    public int strStr(String haystack, String needle) {
        if(!haystack.contains(needle)){
            return -1;
        }
        else{
            char[] haystackChar = haystack.toCharArray();
            char[] needleChars = needle.toCharArray();
            int count = 0;
            for(int i = 0; i < haystackChar.length-1; i++){
                if(count == needleChars.length-1){
                    return i - count;
                }
                if(haystackChar[i] == needleChars[count]) {
                        count = count + 1;
                }
                else {
                    count = 0;
                }
            }
        }
        return  -1;
    }

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int occ = (int) Math.floor(nums.length/2);
        if(nums[0] == nums[occ]){
            return nums[occ];
        }
        return 0;
    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = prices[0];
        for (int i = 1; i <= prices.length -1; i++){
                maxProfit = Math.max(maxProfit,prices[i]-minPrice);
                minPrice = Math.min(minPrice,prices[i]);
        }
        return maxProfit;
    }

    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hashSet = new HashSet<>();
        int maxLength = 0;
        int left = 0;
        for(int right = 0; right< s.length();right++){
            if(!hashSet.contains(s.charAt(right))){
                hashSet.add(s.charAt(right));
                maxLength = Math.max(maxLength,right-left+1);
            }
            else{
                while(s.charAt(left)!=s.charAt(right)){
                    hashSet.remove(s.charAt(left));
                    left++;
                }
                hashSet.remove(s.charAt(left));left++;
                hashSet.add(s.charAt(right));
            }
        }
        return 0;
    }

    public boolean isAnagram(String s, String t) {
        char[] stoCharArray = s.toCharArray();
        Arrays.sort(stoCharArray);
        char[] ttoCharArray = t.toCharArray();
        Arrays.sort(ttoCharArray);
        if(s.length() == t.length()){
            for (int i =0; i <= s.length()-1;i++){
                if(stoCharArray[i] != ttoCharArray[i]){
                    return false;
                }
            }
        }
        else{
            return false;
        }
        return true;
    }

    public int canJump2(int[] nums) {
        int Reach=0;
        int count = 0;
        for(int i=0; i<nums.length; i++){
            if(Reach<i){
                return 0;
            }
            if(Reach < nums.length-1) {
                if (Reach < i + nums[i]) {
                    Reach = i + nums[i];
                }
                count = count +1;
            }
        }
        return count;
    }

    public int[] productExceptSelf(int[] nums) {
        int productWithoutZero = 1;
        int totalProduct =1;
        int zeros = 0;
        for (int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                productWithoutZero = productWithoutZero*nums[1];
            }
            else{
                zeros = zeros+1;
            }
        }
        if(zeros>0){
            totalProduct =0;
        }
        int[] products =  new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                products[i] = totalProduct*productWithoutZero/nums[i];
            }
            else{
                products[i] = productWithoutZero;
            }
        }
        return products;
    }

    public static void main(String[] args) {
        LengthOfLongestSubString lengthOfLongestSubString = new LengthOfLongestSubString();
        //int[] rotate = lengthOfLongestSubString.rotate(new int[]{-1,-100,3,99}, 2);
        System.out.println(lengthOfLongestSubString.canJump2(new int[]{2,3,0,1,4}));

    }
}
