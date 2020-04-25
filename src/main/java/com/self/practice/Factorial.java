package com.self.practice;

public class Factorial {
    public int factorial(int n) {
        if (n==0) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        Factorial factorial = new Factorial();
        System.out.println(factorial.factorial(3));
    }
}
