package com.self.practice;

/**
 * smallest number is founded and placed in the order in each iteration
 */
public class SelectionSort {
    public int[] sort(int[] data) {
        for (int i = 0;i < data.length-2;i++){
            int minIndex = i;
            for (int y=i+1;y<data.length-1;y++){
                if (data[minIndex] > data[y]){
                    int temp = data[minIndex];
                    data[minIndex] = data[y];
                    data[y] = temp;
                }
            }
        }
        return data;
    }

    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        int[] o = {1,2,3,23,42,76,9,7,48,62};
        int[] sortedData = selectionSort.sort(o);
        for (int i=0;i< sortedData.length-1;i++) {
            System.out.println(sortedData[i]);
        }
    }
}
