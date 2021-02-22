package com.self.hRk;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;



class Result {

    /*
     * Complete the 'maxDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY px as parameter.
     */

    public static int maxDifference(List<Integer> px) {
        // Write your code here
        int max = -1;
        int min = px.get(0);
            for(int i =1; i < px.size()-1; i++)
            {
                    int diff = px.get(i) - min;
                    if (diff > max) {
                            max = diff;
                    }
                    if(px.get(i)<min){
                        min = px.get(i);
                    }

            }
        return max;
    }

}

public class MaxDifference {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int pxCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> px = new ArrayList<>();

        for (int i = 0; i < pxCount; i++) {
            int pxItem = Integer.parseInt(bufferedReader.readLine().trim());
            px.add(pxItem);
        }

        int result = Result.maxDifference(px);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

