package com.self.Java26;

import java.util.Arrays;

public class LargestPlusSign {

    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] matrix = new int[n][n];
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = n;
            }
        }
        for (int[] mine: mines
             ) {
            matrix[mine[0]][mine[1]] = 0;
        }
        //left to right
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                count = matrix[i][j] != 0 ? count+1 : 0;
                matrix[i][j] = Math.min(matrix[i][j], count);
            }
        }
        //right to left
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = n-1; j >= 0; j--) {
                count = matrix[i][j] != 0 ? count+1 : 0;
                matrix[i][j] = Math.min(matrix[i][j], count);
            }
        }
        // Step 5: Top -> Bottom
        for (int j = 0; j < n; j++) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                count = (matrix[i][j] == 0) ? 0 : count + 1;
                matrix[i][j] = Math.min(matrix[i][j], count);
            }
        }

        for (int j = 0; j < n; j++) {
            int count = 0;
            for (int i = n-1; i > 0; i--) {
                count = (matrix[i][j] == 0) ? 0 : count + 1;
                matrix[i][j] = Math.min(matrix[i][j], count);
                result = Math.max(result, matrix[i][j]);
            }
        }
        return result;
    }

    public int orderOfLargestPlusSign1(int n, int[][] mines) {
        int[][] matrix = new int[n][n];
        int result =0;
        for (int[] row: matrix
             ) {
            Arrays.fill(row, n);
        }
        for (int[] mine:
             mines) {
            matrix[mine[0]][mine[1]] = 0;
        }

        //left to right
        for (int i = 0; i < n; i++) {
            int count =0;
            for (int j = 0; j < n; j++) {
                count = matrix[i][j] != 0 ? count++ : 0;
                matrix[i][j] = Math.min(matrix[i][j], count);
            }
        }

        //left to right
        for (int i = 0; i < n; i++) {
            int count =0;
            for (int j = n-1; j >= 0; j--) {
                count = matrix[i][j] != 0 ? count++ : 0;
                matrix[i][j] = Math.min(matrix[i][j], count);
            }
        }

        for (int j = 0; j < n; j++) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                count = matrix[i][j] != 0 ? count++ : 0;
                matrix[i][j] = Math.min(matrix[i][j], count);
            }
        }

        for (int j = 0; j < n; j++) {
            int count = 0;
            for (int i = n-1; i >=0; i--) {
                count = matrix[i][j] != 0 ? count++ : 0;
                matrix[i][j] = Math.min(matrix[i][j], count);
                result = Math.max(result, matrix[i][j]);
            }
        }
        return result;
    }

    public int maximumSum(int[] arr) {
        int len = arr.length;
        int[] dp_forward = new int[len];
        int[] dp_backword = new int[len];

        dp_forward[0] = arr[0];
        int max_forward = dp_forward[0];
        for (int i = 1; i < len; i++) {
            dp_forward[i] = Math.max(arr[i], dp_forward[i-1]+ arr[i]);
            max_forward = Math.max(max_forward, dp_forward[i]);
        }

        dp_backword[len-1] = arr[len-1];
        for (int i = len-2; i >= 0; i--) {
            dp_backword[i] = Math.max(arr[i], dp_backword[i+1]+ arr[i]);
        }

        for (int i = 1; i < len - 1; i++) {
            max_forward = Math.max(max_forward, dp_forward[i - 1] + dp_backword[i + 1]);
        }

        return max_forward;
    }

}
