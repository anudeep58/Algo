package com.self.practice;

class Solution {
    public int solution(int[] A) {
        int counts;
        int min_counts = 9999999;
        for (int val : A) {
            counts = 0;
            for (int i : A) {
                if (val == i) {
                    counts += 0;
                } else if (val + i == 7) {
                    counts += 2;
                } else {
                    counts += 1;
                }
            }
                if (counts < min_counts) {
                    min_counts = counts;
                }
            }
        return min_counts;
    }
    }

