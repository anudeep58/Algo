package com.self.practice;

import java.util.*;

public class InitilizationJava implements Comparator<String>{

    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        int d1 = 0, d2 = 0;
        for(int i = 0; i<arr.size();i++){
            d1 = d1 + arr.get(i).get(i);
            d2 = d1 + arr.get(i).get(arr.size()-i-1);
        }
        return Math.abs(d1-d2);
    }

        public int compare(String x, String y) {
            if (x.length() == y.length()) {
                return x.compareTo(y);
            }

            return x.length() - y.length();
        }


    public static void main(String[] args) {
        //HashMap
        HashMap<Integer, String> hm = new HashMap<Integer, String>();
        hm.put(1, "Ram");
        hm.put(2, "Shyam");
        hm.put(3, "Sita");
        System.out.println("Values " + hm);
        //HashSet
        Set<Integer> set = new HashSet<Integer>();
        set.add(1);
        set.add(2);
        //Array
        String[] str1 = new String[5];
        String[] str2 = {"a", "b", "c", "d", "e"};
        InitilizationJava initilizationJava = new InitilizationJava();
        Arrays.sort(str1,initilizationJava);
        String[] str3 = new String[]{"a", "b", "c", "d", "e"};
        str1[0] = "a";
        str1[1] = "b";
        str1[2] = "c";
        str1[3] = "d";
        str1[4] = "e";
    }
}
