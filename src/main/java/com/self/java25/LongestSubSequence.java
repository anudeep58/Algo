package com.self.java25;

public class LongestSubSequence {
    public int findLUSlength(String[] strs) {
        int ans = -1;
        for (int i = 0; i < strs.length; i++) {
            boolean isUncommon = true;
            for (int j = 0; j < strs.length; j++) {
                if(i == j) continue;
                if (isSubsequence(strs[i], strs[j])) {
                    isUncommon = false;
                    break;
                }

            }
            if (isUncommon) {
                ans = Math.max(ans, strs[i].length());
            }

        }
        return ans;
    }

    public boolean isSubsequence(String a, String b) {
        int i =0 , j = 0;
        while (i < a.length() && j < b.length()){
            if(a.charAt(i) == b.charAt(j)){
                i++;
            }
            j++;
        }
        return a.length() == i;
    }

    public static void main(String[] args) {
        String[] strings =  new String[]{"abc", "aXbYc"};
        LongestSubSequence longestSubSequence = new LongestSubSequence();
        System.out.println(longestSubSequence.findLUSlength(strings));
    }
}
