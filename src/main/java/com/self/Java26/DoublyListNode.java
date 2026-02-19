package com.self.Java26;

public class DoublyListNode {
    int key, val;
    DoublyListNode prev;
    DoublyListNode next;

    public DoublyListNode(int key , int val) {
        this.key = key;
        this.val = val;
        prev = next = null;
    }

}
