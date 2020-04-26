package com.self.practice;

import java.util.Arrays;

public class MergeSort {
    public int[] sort(int[] data) {
        return mergeSort(data, 0, data.length-1);
    }
    private int[] mergeSort(int[] data, int start, int end) {
        int[] sorted= new int[data.length];
        if (start < end) {
            int mid = (int) Math.floor((start+end)/2);
            mergeSort(data, start, mid);
            mergeSort(data, mid+1, end);
            sorted = merge(data, start, mid, end);
        }
        return sorted;
    }
    public int[] merge(int[] arrayToSort, int start, int mid, int end){
        int sizeOfLeft = mid-start+1;
        int sizeOfRight = end - mid;
        int[] left = new int[sizeOfLeft];
        int[] right = new int[sizeOfRight];
        for (int i = 0; i < sizeOfLeft; i++) {
            left[i] = arrayToSort[start + i]; // be careful here
        }
        for (int j = 0; j < sizeOfRight; j++) {
            right[j] = arrayToSort[mid + 1 + j]; // be careful
        }
        int i = 0, j = 0;
        for (int k = start; k <= end; k++) {
            if ((j >= sizeOfRight) || (i < sizeOfLeft && left[i] <= right[j])) {
                arrayToSort[k] = left[i];
                i++;
            } else {
                arrayToSort[k] = right[j];
                j++;
            }
        }
        return arrayToSort;
    }

    public static void main(String[] args) {
        MergeSort sorter = new MergeSort();
        int[] data = {98,10,8,17};
        sorter.sort(data);
        System.out.println(Arrays.toString(data));
    }
}
