package com.self.java25;

public class SolutionLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode previous = null;
        while(current != null){
            ListNode temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;

        }
        return previous;
    }
    public void deleteNode(ListNode node) {
        while(node.next != null){

        }
    }

}
