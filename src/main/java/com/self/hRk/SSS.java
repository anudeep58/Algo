package com.self.hRk;

import java.util.*;
import java.io.*;
import java.math.*;

public class SSS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int T = Integer.parseInt(br.readLine()); //size
        for (int tt = 0; tt < T; tt++) {   //
            int n = Integer.parseInt(br.readLine());
            String[] line = br.readLine().split(" "); //line
            boolean valid = true;

            int[] p = new int[n];
            for (int i = 0; i < line.length; i++) {
                p[i] = Integer.parseInt(line[i]);
            }

            int count = 0;
            for (int i = 0; i < line.length; i++) {
                int cur = 0;
                boolean found = false;
                for (int j = 0; j < line.length - 1; j++) {
                    if (p[j] > p[j + 1]) {
                        found = true;

                        if (cur == 2) {
                            valid = false;
                            break;
                        }

                        swap(p, j, j + 1);
                        cur++;
                        count++;
                    } else {
                        cur = 0;
                    }
                }

                if (!found || !valid) {
                    break;
                }
            }

            if (!valid) {
                pw.println("Too chaotic");
            } else {
                pw.println(count);
            }
        }

        pw.flush();
        pw.close();
    }

    static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
