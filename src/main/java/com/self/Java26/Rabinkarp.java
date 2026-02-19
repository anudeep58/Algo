package com.self.Java26;

public class Rabinkarp {
    public int strStr(String haystack, String needle) {

        int haystackLen = haystack.length();
        int needleLen = Integer.MAX_VALUE;
        int result = -1;
        for (int i = 0; i < haystack.length(); i++) {
            int needlenCounter =0 ;
            int haystakCounter = i;
            needleLen = needle.length();
            if(haystack.charAt(haystakCounter) == needle.charAt(needlenCounter)){
                while (haystakCounter < haystackLen && needlenCounter < needle.length() && haystack.charAt(haystakCounter) == needle.charAt(needlenCounter)){
                    needleLen--;
                    haystakCounter++;
                    needlenCounter++;
                }
            }
            if (needleLen ==0) {
                result = i;
                break;
            }

        }
        return result;
    }

    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();

        for (int i = 1; i <= len/2; i++) {
            String sub = s.substring(0, i);
            boolean ok = true;

            for (int j = 0; j < len; j += i) {
                if(!s.substring(j,j+i).contains(sub)){
                    ok = false;
                }
            }

            if (ok)
                return true;
            
        }
        return false;
    }

    public static void main(String[] args) {
        new Rabinkarp().strStr("sadbutsad", "sad");
    }
}
