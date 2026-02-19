package com.self.Java26;

import java.util.ArrayList;
import java.util.List;

public class Palindrom {
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += expendFromCenter(s, i, i);
            count += expendFromCenter(s, i, i+1);
        }
        return count;
    }

    private int expendFromCenter(String s, int left, int right) {
        int count = 0;
        while(left > 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            count++;
            left--;
            right++;
        }
        return count;
    }

    public String longestPalindrome(String s) {
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            maxLen = Math.max(maxLen, expendFromCenter(s, i, i));
            maxLen = Math.max(maxLen, expendFromCenter(s, i, i+1));
        }
        return "";
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;

        int[] freq = new int[26];

        for (int i = 0; i < p.length(); i++) {
            freq[p.charAt(i) - 'a']++;
        }

        int left = 0, right = 0;
        int counter = p.length();

        while (right < s.length()){
            if(freq[s.charAt(right) - 'a'] > 0){
                counter--;
            }

            freq[s.charAt(right) - 'a']--;
            right++;
            if(right-left == p.length()){
                if(counter==0){
                    result.add(left);
                }
                if(freq[s.charAt(left)-'a'] > 0) {
                    counter++;
                }
                freq[s.charAt(left)-'a']++;
                left++;
            }
        }
        return result;
    }



}
