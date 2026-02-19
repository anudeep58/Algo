//package com.self.Java26;
//
//import scala.Int;
//
//import java.util.HashMap;
//import java.util.LinkedList;
//import java.util.Map;
//import java.util.Queue;
//
//public class LRUCache {
//
//     class Node{
//        int key, val;
//        Node prev;
//        Node next;
//
//            public Node(int key , int val) {
//            this.key = key;
//            this.val = val;
//        }
//    }
//
//    Map<Integer, Node> map;
//    Node head, tail;
//    int capacity;
//
//    public LRUCache(int capacity) {
//        map =  new HashMap<>(capacity);
//        this.capacity = capacity;
//        head = new Node(0,0);
//        tail = new Node(0,0);
//
//        head.next = tail;
//        tail.prev = head;
//    }
//
//    public int get(int key) {
//        if(!map.containsKey(key)) return -1;
//        Node node = map.get(key);
//        remove(node);
//        insert(node);
//        return node.val;
//    }
//
//    private void insert(Node node) {
//        node.next = head.next;
//        node.prev = head;
//        head.next.prev = node;
//        head.next = node;
//
//    }
//
//    private void remove(Node node) {
//        node.prev.next = node.next;
//        node.next.prev = node.prev;
//    }
//
//
//    public void put(int key, int value) {
//        if(map.containsKey(key)){
//            Node node = map.get(key);
//            node.val = value;
//            remove(node);
//            insert(node);
//        }
//        else{
//            if(map.size() == capacity){
//                Node lru = tail.prev;
//                remove(lru);
//                map.remove(lru.key);
//            }
//            Node newNode = new Node(key, value);
//            map.put(key, newNode);
//            insert(newNode);
//        }
//    }
//        public static void main(String[] args) {
//
//            LRUCache cache = new LRUCache(2);
//
//            System.out.println("Put 1,1");
//            cache.put(1,1);
//
//            System.out.println("Put 2,2");
//            cache.put(2,2);
//
//            System.out.println("Get 1: " + cache.get(1));
//            // Expected: 1
//
//            System.out.println("Put 3,3 (Evicts 2)");
//            cache.put(3,3);
//
//            System.out.println("Get 2: " + cache.get(2));
//            // Expected: -1
//
//            System.out.println("Put 4,4 (Evicts 1)");
//            cache.put(4,4);
//
//            System.out.println("Get 1: " + cache.get(1));
//            // Expected: -1
//
//            System.out.println("Get 3: " + cache.get(3));
//            // Expected: 3
//
//            System.out.println("Get 4: " + cache.get(4));
//            // Expected: 4
//        }
//
//}
