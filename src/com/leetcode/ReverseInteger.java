package com.leetcode;

public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(new ReverseInteger().reverse(-2147483648));
    }

    public int reverse(int x) {
        int len = 0;
        int temp = x;
        while (temp != 0) {
            len++;
            temp = temp / 10;
        }
        long sum = 0;
        while (x != 0) {
            long last = x % 10;
            sum = sum + last * findPow(--len);
            if (sum > Integer.MAX_VALUE || (x <0 && sum < Integer.MIN_VALUE)) {
                return 0;
            }
            x = x / 10;
        }
        if (sum >= Integer.MAX_VALUE) {
            return 0;
        }
        return x < 0 ? -1 * (int) sum : (int) sum;
    }

    private long findPow(int j) {
        int multiply = 1;
        for (int i = 0; i < j; i++) {
            multiply = multiply * 10;
        }
        return multiply;
    }
}
