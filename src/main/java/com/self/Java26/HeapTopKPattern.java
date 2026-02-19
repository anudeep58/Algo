package com.self.Java26;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HeapTopKPattern {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> objects = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        objects.addAll(map.entrySet());
        StringBuilder result = new StringBuilder();
         while (!objects.isEmpty()){
             Map.Entry<Character, Integer> poll = objects.poll();
             for (int i = 0; i < poll.getValue(); i++) {
                 result.append(poll.getKey());
             }
         }
        return result.toString();
    }
}
