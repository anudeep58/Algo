package com.self.practice;

import java.util.Arrays;

public class InsertionSort {
    public int[] sort(int[] data) {
        for (int i = 1; i < data.length; i++) {
            int current = data[i];
            int j = i - 1;
            while (j >= 0 && data[j] > current) {
               data[j+1] = data[j];
               j--;
            }
            data[j+1] = current;
        }
        return data;
    }

    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        int[] o = {4, 2, 1, 23, 42, 62, 9, 7, 48, 62};
        int[] sortedData = insertionSort.sort(o);
        System.out.println(Arrays.toString(sortedData));
    }
}
