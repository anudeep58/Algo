package com.self.practice;

public class BinarySearch {
    static int introTutorial(int V, int[] arr) {
        int index = -1;
        int first = 0;
        int last = arr.length-1;
        while(first<=last){
            int middle = (first+last)/2;
            if(arr[middle] < V){
                first = middle;
            }
            if(arr[middle] > V){
                last = middle;
            }
            if(arr[middle] == V){
                return middle;
            }
        }
      return index;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 3, 4, 10, 40 };
        int x = 10;
        int result = BinarySearch.introTutorial(x,arr);
        if (result == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at "
                    + "index " + result);
    }
}
