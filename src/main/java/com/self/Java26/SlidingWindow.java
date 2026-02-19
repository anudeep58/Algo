package com.self.Java26;

import java.util.*;

import static java.lang.Math.max;

public class SlidingWindow {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> character =  new HashSet<>();
        int left = 0, right =0, maxLen =0;
        while (right < s.length()) {
            if (!character.contains(s.charAt(right))) {
                character.add(s.charAt(right));
            }
            else {
                while (character.contains(s.charAt(right))){
                    character.remove(s.charAt(left));
                    left++;
                }
                character.add(s.charAt(right));
            }
            maxLen = max(maxLen, right-left+1);
            right++;
        }
        return maxLen;
    }

    //[1,2,3,2,2]
    public int totalFruit(int[] fruits) {
        int left = 0;
        int maxDistFruit =0 ;
        int distinctAllowed = 2;
        Map<Integer, Integer> objectObjectHashMap = new HashMap<>();
        for (int right = 0; right < fruits.length; right++) {
            if(!objectObjectHashMap.containsKey(fruits[left])){
                if(objectObjectHashMap.size() > distinctAllowed){
                    objectObjectHashMap.remove(fruits[left]);
                    left++;
                }
            }
            objectObjectHashMap.put(fruits[right], objectObjectHashMap.getOrDefault(fruits[right], 0)+1);
            maxDistFruit = Math.max(maxDistFruit, objectObjectHashMap.values().stream().reduce((a,b) -> a+b).get());
        }
        return maxDistFruit;
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;

        int[] PFreq = new int[26];
        int[] SsubFreq =  new int[26];

        for (char c:
             p.toCharArray()) {
            PFreq[c -'a']++;
        }

        int size = p.length();
        int right = 0;

        while (right < s.length()){
            SsubFreq[s.charAt(right) - 'a']++;

            if(right >= size){
                SsubFreq[s.charAt(right - size) - 'a']--;
            }

            if(Arrays.equals(PFreq, SsubFreq)){
                result.add(right-size+1);
            }
            right++;
        }
        return result;
    }

    public boolean checkInclusion(String s1, String s2) {
        int s1Len = s1.length();
        int s2Len = s2.length();

        int[] s1Array = new int[26];
        int[] s2Array = new int[26];

        for (char s: s1.toCharArray()
             ) {
            s1Array[s - 'a']++;
        }

        int right =0;
        int left = 0;
        while (right < s2Len){
            s2Array[s2.charAt(right) - 'a']++;

            while (right - left >= s1Len){
                s2Array[s2.charAt(left) - 'a']--;
                left++;
            }

            if(Arrays.equals(s1Array, s2Array)){
                return true;
            }
            right++;
        }
        return false;
    }

    public static void main(String[] args) {
        new SlidingWindow().checkInclusion("ab", "eidbaooo");
    }
}
