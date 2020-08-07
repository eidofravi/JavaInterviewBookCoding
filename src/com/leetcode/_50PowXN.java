package com.leetcode;

public class _50PowXN {

    public static void main(String[] args) {
        System.out.println(new _50PowXN().power(2, 5));
    }

    public double power(double x, int n) {
        if (n == 0) {
            return 1;
        } else if (n % 2 == 0) {
            double temp = power(x, n / 2);
            return temp * temp;
        } else {
            return x * power(x, n - 1);
        }
    }
}


