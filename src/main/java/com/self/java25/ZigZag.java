package com.self.java25;

import java.util.Arrays;
import java.util.Locale;

public class ZigZag {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }
        StringBuilder[] row = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            row[i] = new StringBuilder();
        }
        int currentRow =0;
        boolean sideCheck = false;
        char[] chars = s.toCharArray();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {

            row[currentRow].append(chars[i]);
            if(currentRow == numRows -1 || currentRow == 0){
                sideCheck = !sideCheck;
            }
            if(!sideCheck){
                currentRow = currentRow -1;
            }
            else
            {
                currentRow = currentRow +1;
            }
        }
        for (int i = 0; i < numRows; i++) {
            result.append(row[i]);
        }
        return String.valueOf(result);
    }

    public String reverseWords(String s) {
        String[] s1 = s.trim().split(" ");
        StringBuilder reversed = new StringBuilder();
        for (int i = s1.length-1; i >=0 ; i--) {
            if(s1[i] != ""){
                reversed.append(s1[i]);
                if(i!=0){
                    reversed.append(" ");
                }
            }
        }
        return reversed.toString();
    }

    public String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();
        Arrays.sort(strs);
        for (int i = 0; i < Math.min(strs[0].length(),strs[strs.length-1].length()); i++) {
            if(strs[0].toCharArray()[i] != strs[strs.length-1].toCharArray()[i]){
                return result.toString();
            }
            result.append(strs[0].toCharArray()[i]);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        ZigZag zigZag = new ZigZag();
        System.out.println(zigZag.convert("PAYPALISHIRING",3));
    }
}
