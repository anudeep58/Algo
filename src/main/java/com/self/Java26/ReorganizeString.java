package com.self.Java26;

import scala.Int;

import javax.sound.midi.Receiver;
import java.util.*;

public class ReorganizeString {
    public String reorganizeString(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        PriorityQueue<Character> frequency =  new PriorityQueue<>((a, b) -> Integer.compare(freqMap.get(b), freqMap.get(a)));;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
                freqMap.put(s.charAt(i), freqMap.getOrDefault(s.charAt(i), 0)+1);
        }
        Character previous = null;
        freqMap.forEach((k,v) -> frequency.add(k));
        while (!frequency.isEmpty()) {
            char first = frequency.poll();
            if(previous != null && first == previous){
                if(frequency.isEmpty()) return "";
                char second = frequency.poll();
                stringBuilder.append(second);
                freqMap.put(second, freqMap.getOrDefault(second, 0)-1);
                if(freqMap.get(second) > 0) {
                    frequency.add(second);
                }
                frequency.offer(first);
                previous = second;
            }
            else{
                stringBuilder.append(first);
                freqMap.put(first, freqMap.getOrDefault(first, 0)-1);
                if(freqMap.get(first) > 0) {
                    frequency.offer(first);
                }
                previous = first;
            }
        }
        return stringBuilder.length() == s.length() ? stringBuilder.toString() : "";
    }

    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> freqMap = new HashMap<>();
        for (String s: words) {
            freqMap.put(s, freqMap.getOrDefault(s,0)+1);
        }
        PriorityQueue<String> queue = new PriorityQueue<>((a,b) ->  {
            if(!freqMap.get(a).equals(freqMap.get(b))){
                return freqMap.get(b) - freqMap.get(a);
            }
            return a.compareTo(b);
        });
        queue.addAll(freqMap.keySet());
        List<String> result = new ArrayList<>();
        for (int i = k; i > 0; i--) {
            if(!queue.isEmpty()) {
                result.add(queue.poll());
            }
        }
        return result;
    }

    public int[][] kClosest(int[][] points, int k) {
        HashMap<Double, int[]> freqMap = new HashMap<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> (a[0] * a[0]) + (a[1] * a[1])));
        for (int[] point : points) {
            queue.offer(point);
        }
        int[][] result = new int[k][2];
        int i = 0;

        while (i < k) {
            result[i++] = queue.poll();
        }
        return result;

    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> elements = new PriorityQueue<>((a,b) -> Integer.compare(a,b));
        for (int num: nums
             ) {
            elements.offer(num);
            while (elements.size() > k){
                elements.poll();
            }
        }
        return elements.poll();
    }

    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> elements = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        for (int[] nums: matrix
             ) {
            for (int num: nums
                 ) {
                elements.offer(num);
                while (elements.size() > k){
                    elements.poll();
                }
            }
        }
        return elements.poll();
    }

    public double[] medianSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> elements = new PriorityQueue<>((a,b) -> Integer.compare(a,b));
        double[] result = new double[nums.length];
        int counter =0;
        for (int num: nums
        ) {
            elements.offer(num);
            if(elements.size() == k){
                if(k%2 == 0){
                    int left = k/2 -1;
                    int right = k/2;
                    for (int i = 0; i < left; i++) {
                        elements.poll();
                    }
                    result[counter++] = (elements.poll()+elements.poll())/2;
                    for (int i = 0; i < left; i++) {
                        elements.offer(nums[i]);
                    }
                }
                else{
                    int element = Math.floorDiv(k,2);
                    for (int i = 0; i < element; i++) {
                        elements.poll();
                    }
                    result[counter++] = elements.poll();
                    for (int i = 0; i < element; i++) {
                        elements.offer(nums[i]);
                    }
                }
            }
            while (elements.size() > k){
                elements.poll();
            }
        }
        return result;
    }

    public int leastInterval(char[] tasks, int n) {

        // 1️⃣ Frequency using HashMap
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : tasks) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        // 2️⃣ Max heap of frequencies
        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Collections.reverseOrder());

        for (int freq : freqMap.values()) {
            maxHeap.offer(freq);
        }

        int time = 0;

        // 3️⃣ Process in cycles of n+1
        while (!maxHeap.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int cycle = n + 1;

            while (cycle > 0 && !maxHeap.isEmpty()) {
                int curr = maxHeap.poll();
                curr--;
                temp.add(curr);
                time++;
                cycle--;
            }

            for (int remaining : temp) {
                if (remaining > 0) {
                    maxHeap.offer(remaining);
                }
            }

            if (maxHeap.isEmpty()) break;

            time += cycle; // idle time
        }

        return time;
    }


    public static void main(String[] args) {
        ReorganizeString reorganizeString = new ReorganizeString();
//        System.out.println(reorganizeString.reorganizeString("aab"));
//        System.out.println(reorganizeString.medianSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3));
        System.out.println(reorganizeString.leastInterval(new char[]{'A','A','A','B','B','B'},2));
    }
}
