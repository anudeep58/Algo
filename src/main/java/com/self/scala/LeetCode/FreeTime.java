package com.self.scala.LeetCode;

import java.util.*;

public class FreeTime {
    public int addDigit(int digit){
        int sum = 0;
        if(digit < 10){
            return digit;
        }
        else{
            while(digit>0) {
                int lastNumber = digit % 10;
                sum = sum + lastNumber;
                digit = digit / 10;
            }
        }
        return sum;
    }

    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        Map<String, Integer> mapOfNumber = new HashMap<String,Integer>(){{
            put("I",1);
            put("V",5);
            put("X",10);
            put("L",50);
            put("C",100);
            put("D",500);
            put("M",1000);
        }};
        if(chars.length == 0){
            return 0;
        }
        int sum = mapOfNumber.get(String.valueOf(chars[chars.length-1]));
        if(chars.length>1) {
            for (int i = chars.length - 2; i >= 0; i--) {
                if(mapOfNumber.get(String.valueOf(chars[i]))<mapOfNumber.get(String.valueOf(chars[i+1]))){
                    sum =sum - mapOfNumber.get(String.valueOf(chars[i]));
                }
                else{
                    sum = sum + mapOfNumber.get(String.valueOf(chars[i]));
                }
            }
        }
        return sum;
    }

    public boolean isPalindrome(String s) {
        String s1 = s.replaceAll("[^a-zA-Z]", "").toLowerCase(Locale.ROOT);
        char[] charArray = s1.toCharArray();
        if(s1.length() == 0){
            return true;
        }
        for(int i =0; i <= (charArray.length-1)/2;i++){
            if(charArray[i] != charArray[charArray.length -i -1]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        FreeTime freeTime = new FreeTime();
        System.out.println(freeTime.isPalindrome("A man, a plan, a canal: Panama"));
    }
}
