package com.self.tree;

import java.util.*;

public class LevelOrderTraversal {
    public static void levelOrderTraversal(Node node){
        if(node == null){
            return;
        }
        Queue<Node> queue =  new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()){
            Node poll = queue.poll();
            System.out.println(poll.data);
            if(poll.left != null) queue.offer(poll.left);
            if(poll.right != null) queue.offer(poll.right);
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result =  new ArrayList<>();

        if (root == null){
            return result;
        }
        Queue<TreeNode> queue =  new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> levelNodes = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                levelNodes.add(node.val);
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            result.add(levelNodes);
        }
        return result;
    }

    public List<List<Integer>> levelOrderRecursive(TreeNode root) {
        int height = getHeight(root);
        List<List<Integer>> result =  new ArrayList<>();
        for (int i = 0; i < height; i++) {
            List<Integer> currentLevel = new ArrayList<>();
            collectLevel(root, i, currentLevel);
            result.add(currentLevel);
        }
        return result;
    }

    private void collectLevel(TreeNode root, int i, List<Integer> currentLevel) {
        if(root == null){
            return;
        }
        if(i == 0){
            currentLevel.add(root.val);
            return;
        }
        collectLevel(root.left, i-1, currentLevel);
        collectLevel(root.right, i-1, currentLevel);
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result =  new ArrayList<>();
        boolean leftToRight = true;
        if (root == null){
            return result;
        }
        Queue<TreeNode> queue =  new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            int size = queue.size();
            Deque<Integer> levelNodes = new ArrayDeque<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(leftToRight) {
                    levelNodes.addFirst(node.val);
                }
                else{
                    levelNodes.addLast(node.val);
                }
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            result.add(new ArrayList<>(levelNodes));
            leftToRight = !leftToRight;
        }
        return result;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }
        if(p == null || q ==null){
            return false;
        }
        return p.val == q.val && isSameTree(p.left,q.left) && isSameTree(p.right, q.right);
    }

}
