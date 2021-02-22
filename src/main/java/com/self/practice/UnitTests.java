package com.self.practice;

public class UnitTests {
    boolean[] arr = new boolean[3];
    int count =0;

    public void setArr(boolean[] arr, int x) {
        arr[x] = true;
        count++;
    }

    void fun(){
        if(arr[0] && arr[++count -1] | arr[count - 2]){
            count++;
            System.out.println("count = "+ count);
        }
    }

    public static void main(String[] args) {
        UnitTests unitTests = new UnitTests();
        unitTests.setArr(unitTests.arr,0);
        unitTests.setArr(unitTests.arr,1);
        unitTests.fun();

    }

}
