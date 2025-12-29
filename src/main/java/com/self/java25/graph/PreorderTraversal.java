package com.self.java25.graph;

import scala.Int;

import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> objectArrayList = new ArrayList<>();
        preOrder(root, objectArrayList);
        return objectArrayList;
    }
    private void preOrder(TreeNode node, List<Integer> res){
        if(node == null){
            return;
        }
        res.add(node.val);
        preOrder(node.left, res);
        preOrder(node.right, res);
    }

    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = 0, max =0;
        while (right < chars.length-1){
            right++;
            if(chars[left] == chars[right]){
                left++;
            }
            max = Math.max(max, right-left+1);
        }
        return max;
    }



    public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return Math.min(left, right) + 1;
    }


    public static void main(String[] args) {
        new PreorderTraversal().lengthOfLongestSubstring("abcabcbb");
    }
}
