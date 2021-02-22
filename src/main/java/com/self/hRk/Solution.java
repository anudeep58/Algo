package com.self.hRk;

import com.sun.corba.se.impl.resolver.SplitLocalResolverImpl;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution{

    public boolean solution(String S) {
        // write your code in Java SE 8
        int sum =0;
        for(int i=0;i<S.length();i++){
            if(S.charAt(i) == ('b')) sum = sum-1;
            if(sum<0 && S.charAt(i) == ('a')) return false;
        }
        System.out.println(sum);

        return true;
    }

    public static void main(String[] args){

//        Scanner in = new Scanner(System.in);
//        int testCases = Integer.parseInt(in.nextLine());
//        while(testCases>0){
//            String line = in.nextLine();
//            Pattern p = Pattern.compile("<(.+)>([^<]+)</\\1>");
//            Matcher m = p.matcher(line);
//            m.find();
//            System.out.println(m.group(1));
//            //line.equals(new StringBuilder(line).reverse().toString())
//            //Write your code here
//
//            testCases--;
        Solution s = new Solution();
        System.out.println(s.solution("aabbab"));
        }
    }
