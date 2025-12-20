package com.self.java25;

import java.util.*;

public class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        recurse(res, 0, 0, "", n);
        return res;
    }

    public void recurse(List<String> res, int left, int right, String s, int n) {
        if (s.length() == n * 2) {
            res.add(s);
            return;
        }

        if (left < n) {
            recurse(res, left + 1, right, s + "(", n);
        }

        if (right < left) {
            recurse(res, left, right + 1, s + ")", n);
        }
    }

    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(slow != fast);
        slow = nums[0];
        while (slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;
        int j = n -1;
        int k = m + n - 1;
        while(j >=0){
            if(i >=0 && nums1[i] > nums2[j]){
                nums1[k] = nums1[i];
                k--; i--;
            }
            else{
                nums1[k] = nums2[j];
                k--; j--;
            }
        }
    }

    public String minRemoveToMakeValid(String s) {
        char[] charsArray = s.toCharArray();
        StringBuilder result = new StringBuilder();
        Stack<Character> characterStack = new Stack<>();
        int leftParenthesis = 0, rightParenthesis = 0;
        for (int i = 0; i <= charsArray.length-1; i++) {
            if (charsArray[i] == '('){
                leftParenthesis++;
            }
            if(charsArray[i] == ')'){
                rightParenthesis++;
            }
            if(rightParenthesis > leftParenthesis){
                rightParenthesis--;
            }
            else {
                characterStack.add(charsArray[i]);
            }
        }
        while (!characterStack.empty()){
            char currentChar = characterStack.pop();
            if(currentChar == '(' && leftParenthesis > rightParenthesis){
                leftParenthesis--;
            }
            else {
                result.append(currentChar);
            }
        }
        return result.reverse().toString();
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Set<List<Integer>> answer = new HashSet<>();
        List<Integer> teampList = new ArrayList<>();
        getAllCombination(candidates, target, 0, answer, teampList);
        return new ArrayList<>(answer);
    }

    public void getAllCombination(int[] candidates, int target, int i, Set<List<Integer>> answer, List<Integer> teampList) {
        if(i >= candidates.length-1 || target < 0){
            return;
        }
        if(target == 0){
            answer.add(teampList);
            return;
        }
        teampList.add(candidates[i]);
        getAllCombination(candidates, target-candidates[i], i+1, answer, teampList);
        getAllCombination(candidates, target-candidates[i], i, answer, teampList);
        teampList.remove(teampList.size()-1);
        getAllCombination(candidates, target, i+1, answer, teampList);

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.generateParenthesis(3);
    }

}
