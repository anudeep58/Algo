package com.self.java25;

// gas = [1,2,3,4,5], cost = [3,4,5,1,2]


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Circuit {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0, startIndex = 0, currentGas = 0;
        for(int i =0; i <= gas.length -1; i++){
            totalCost = totalCost + cost[i];
            totalGas = totalGas + gas[i];
            currentGas = currentGas + gas[i] - cost[i];
            if (currentGas < 0){
                startIndex = i + 1;
                currentGas = 0;
            }
        }
        if(totalCost <= totalGas){
            return startIndex;
        }
        return -1;
    }

    public int[] productExceptSelf(int[] nums) {
        int hasZero = 0;
        int product  = 1;
        int[] productArray = new int[nums.length];
        for(int i = 0; i <= nums.length-1;i++){
            if(nums[i] !=0) {
                product = product * nums[i];
            }
            else{
                hasZero = hasZero + 1;
            }
        }
        for(int i = 0; i <= nums.length-1;i++){
            if(hasZero == 1){
                if(nums[i] !=0){
                    productArray[i] = 0;
                }
                else{
                    productArray[i] = product;
                }
            }
            if(hasZero > 1){
                productArray[i] = 0;
            }
            if(hasZero ==0){
                productArray[i] = product/nums[i];
            }
        }
        return productArray;
    }

    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }

        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i <= numRows - 1; i++) {
            rows[i] = new StringBuilder();
        }

        int currentRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows[currentRow].append(c);
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }
            if (goingDown) {
                currentRow = currentRow + 1;
            } else {
                currentRow = currentRow - 1;
            }
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows){
            result.append(row);
        }
        return result.toString();
    }
}