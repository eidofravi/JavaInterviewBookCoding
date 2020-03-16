package com.leetcode;

import java.util.Arrays;

public class SumOfSubArray {
    public static void main(String[] args) {
        System.out.println(maxSubArraySum(new int[]{-2, -3, 4, -1, -2, 1, 5, -3})); //4, -1, -2, 1, 5 = 7
        System.out.println(maxSubArraySum(new int[]{-23, -33, -2, -27, 0, -39})); //4, -1, -2, 1, 5 = 7
    }

    static int maxSubArraySum(int[] a)
    {
        int size = a.length;
        int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;

        for (int i = 0; i < size; i++)
        {
            max_ending_here = max_ending_here + a[i];
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
            if (max_ending_here < 0)
                max_ending_here = 0;
        }
        return max_so_far;
    }

}
