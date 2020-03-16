package com.leetcode;

public class SumOfContinuousNumber {
    public static void main(String[] args) {
        System.out.println(maxSubArraySum(new int[]{4, 5, 7, 8, 1, 2, 3, 4, 8, 9, 2, 5, 6, 7, 8, 9, 10, 11, 1})); //4, -1, -2, 1, 5 = 7
        //System.out.println(maxSubArraySum(new int[]{-23, -33, -2, -27, 0, -39})); //4, -1, -2, 1, 5 = 7
    }

    static int maxSubArraySum(int[] arr) {
        int total = 0;
        int sum = arr[0];
        int prev = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == prev + 1) {
                sum = sum + arr[i];
            } else {
                total = Math.max(total, sum);
                sum = prev;
            }
            prev = arr[i];
        }
        return total;
    }
}
