package com.self.practice;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeTwoSortedArraysGAP {
    public static int nextGap(int gap){
        if (gap<=1){
            return 0;
        }
        else{
            return (gap/2) + gap%2;
        }
    }
    public static int[] merge(int[] array1,int[] array2){
        int[] sorted = new int[array1.length+array2.length];
        int i,j,gap=array1.length+array2.length;
        for(gap = nextGap(gap);gap>0;gap=nextGap(gap)){
            for(i=0;i+gap<array1.length;i++){
                if(array1[i]>array1[i+gap]){
                    int temp = array1[i];
                    array1[i] = array1[i+gap];
                    array1[i+gap] = temp;
                }
            }
            for(j= gap > array1.length? gap - array1.length:0;j < array2.length && i < array1.length;i++,j++) {
                if(array1[i] > array2[j]){
                    int temp = array1[i];
                    array1[i] = array2[j];
                    array2[j] = temp;
                }
            }
            if(j<array2.length){
                for (j = 0; j + gap < array2.length; j++) {
                    if (array2[j] > array2[j + gap]) {
                        int temp = array2[j];
                        array2[j] = array2[j + gap];
                        array2[j + gap] = temp;
                    }
                }
            }
        }
        sorted = new int[array1.length + array2.length];

        System.arraycopy(array1, 0, sorted, 0, array1.length);
        System.arraycopy(array2, 0, sorted, array1.length, array2.length);
        return sorted;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {2, 4, 6, 8};
        System.out.println(Arrays.toString(merge(arr1, arr2)));
    }
}
