package com.self.Java26;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    class Node {
        int key,val;
        Node prev;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    int capacity;
    Map<Integer, Node> cache;
    Node head = new Node(0,0);
    Node tail = new Node(0,0);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
        cache = new HashMap<>(capacity);
    }

    public int get(int key) {
        if(!cache.containsKey(key)) return -1;
        Node node = cache.get(key);
        remove(node);
        insert(node);
        return node.val;
    }

    private void insert(Node node) {
        head.next.prev = node;
        node.next = head.next;
        node.prev = head;
        head.next = node;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void put(int key, int value) {
        if(cache.size() == capacity){
            Node c = new Node(key, value);
            if(!cache.containsKey(key)){
                Node last = tail.prev;
                remove(last);
                cache.remove(last.key);
                cache.put(key, c);
                insert(c);
            } else {
                Node n = cache.get(key);
                n.val = value;
                remove(n);
                insert(n);
            }
        } else {
            Node c = new Node(key, value);
            cache.put(key, c);
            insert(c);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
