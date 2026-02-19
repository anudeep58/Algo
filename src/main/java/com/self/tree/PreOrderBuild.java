package com.self.tree;

public class PreOrderBuild {
    static int index = 0;
    public static Node buildTree(int[] order){
        if(index == -1 || index >= order.length){
            index++;
            return null;
        }
        Node node = new Node(order[index]);
        index++;
        node.left = buildTree(order);
        node.right = buildTree(order);
        return node;
    }

    public static void printPreOrder(Node node){
        if(node == null){
            return;
        }
        System.out.println(node.data + "");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }

    public static void main(String[] args) {
        int[] preorder = {
                1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1
        };

        Node root = buildTree(preorder);

        // Verify by printing preorder again
        System.out.println("================Print==============");
        printPreOrder(root);
    }

}
