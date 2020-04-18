package com.self.practice;

public class BubbleSort {

    public int[] sort(int[] data) {
        for (int i = 0;i < data.length-2;i++){
            for (int y=0;y<data.length-2-i;y++){
                if (data[y] >data[y+1]){
                    int temp = data[y];
                    data[y] = data[y+1];
                    data[y+1] = temp;
                }
            }
        }
        return data;
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] o = {1,2,3,23,42,76,9,7,48,62};
        int[] sortedData = bubbleSort.sort(o);
        for (int i=0;i< sortedData.length-1;i++) {
            System.out.println(sortedData[i]);
        }
    }
}
