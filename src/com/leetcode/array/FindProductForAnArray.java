package com.leetcode.array;

import java.util.Deque;
import java.util.LinkedList;

public class FindProductForAnArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        new FindProductForAnArray().productExceptSelf(nums);
    }

    public int[] productExceptSelf(int[] nums) {

        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        int[] output = new int[nums.length];


        for (int i = 0; i < nums.length; i++) {
            left[i] = nums[i] * (i == 0 ? 1 : left[i - 1]);
        }

        for (int i = nums.length - 1; i > 0; i--) {
            right[i] = nums[i] * (i == nums.length - 1 ? 1 : right[i + 1]);
        }

        for (int i = 0; i < nums.length; i++) {
            output[i] = (i > 0 ? left[i - 1] : 1) * (i < nums.length - 1 ? right[i + 1] : 1);
        }

        return output;
    }
}
