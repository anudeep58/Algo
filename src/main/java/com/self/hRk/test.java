package com.self.hRk;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntBinaryOperator;
import java.util.stream.Collectors;

public class test {

    static long triplets(int[] a, int[] b, int[] c) {
        long t = 0L;
       for(int i=0; i<a.length-1;i++){
            for(int y=0; y<b.length-1;y++){
                for(int z=0; z<c.length-1;z++){
                    if(a[i]<b[y] && b[y]>c[z]){
                        t += 1;
                    }
                }
            }
       }
       return t;
    }
    static int[] insertionSort(int[] arr){
        for(int i=1; i<=arr.length-1; i++){
            int current = arr[i];
            int j = i-1;
            while(j >= 0 && arr[j] > current){
                arr[j+1] = arr[j];
                j = j -1;
            }
            arr[j+1] = current;
        }
        return arr;
    }

    static String balancedSums(List<Integer> arr) {
        int n = arr.size();
        int i = 0;
        int j = n-1;
        int left = 0;
        int right = 0;
        while ( i < n && j >= 0)
        {
            if ( left == right && i == j) {
                return "YES";
            }
            if ( left > right) {
                right += arr.get(j);
                j--;
            } else
            {
                left += arr.get(i);
                i++;
            }
        }
        return "NO";
    }

    static int[] insertionSort1(int n, int[] arr) {
        for(int i = n-1;n>=0;n--){
            int j = i-1;
            int current = arr[i];
            while(j >=0 && current<arr[j]){
                arr[j+1] = arr[j];
                j=j-1;
            }
            arr[j] = current;
        }
        return arr;
    }
    static int pairs(int k, int[] arr) {
        List<Integer> ints = Arrays.stream(arr).boxed().collect(Collectors.toList());
        int count1 = (int)ints.stream().filter(i -> ints.contains(i - k)).count();
        AtomicInteger count = new AtomicInteger();
        ints.forEach( x -> {
            if(ints.contains(x+k)){
                count.getAndIncrement();
            };
        });
        IntBinaryOperator ibo = (x, y) -> (x + y);
        int value = 0;
        return count.accumulateAndGet(value,ibo);
    }

    public static void main(String[] args) {
        int[] o = {4,3, 2, 1, 1};
        int[] sortedData = test.insertionSort(o);
        List<Integer> collect = Arrays.stream(o).boxed().collect(Collectors.toList());
        System.out.println(balancedSums(collect));
    }
}
