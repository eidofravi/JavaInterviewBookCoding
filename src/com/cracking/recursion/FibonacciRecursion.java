package com.cracking.recursion;

public class FibonacciRecursion {

    public static void main(String[] args) {
        //new FibonacciRecursion().fibn(0, 1, 2);
        int num = new FibonacciRecursion().fib(5);
        System.out.println(num);
    }

    private void fibn(int f1, int f2, int i) {
        if (i == 5) {
            System.out.println(f1 + f2);
            return;
        }
        fibn(f2, f1+f2, ++i);
    }

    private int fib(int i) {
        if (i == 0) return 0;
        if (i == 1) return 1;
       return fib(i - 1) + fib(i-2);
    }
}
