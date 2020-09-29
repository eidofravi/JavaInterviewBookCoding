package com.leetcode.array;

import java.util.Deque;
import java.util.LinkedList;

public class LongContinuousSubArrWithAbsDiffLessThanEquals {
    public static void main(String[] args) {
        // int nums[] = {8, 2, 4, 7};
        //int limit = 4;

        // int nums[] = {4,2,2,2,4,4,2,2}; //3
        // int limit = 0;

        //int nums[] = {10, 1, 2, 4, 7, 2}; //4
        //int limit = 5;

        //int nums[] = {8, 2, 3, 6, 7, 4}; //4
        // int limit = 3;

        //  int nums[] = {24,12,71,33,5,87,10,11,3,58,2,97,97,36,32,35,15,80,24,45,38,9,22,21,33,68,22,85,35,83,92,38,59,90,42,64,61,15,4,40,50,44,54,25,34,14,33,94,66,
        //   27,78,56,3,29,3,51,19,5,93,21,58,91,65,87,55,70,29,81,89,67,58,29,68,84,4,51,87,74,42,85,81,55,8,95,39};
        //  int limit = 87; //25

        // [33,95,93,21,58,91,65,87,55,70,29,81,89,67,58,29,68,84,4,51,87,74,42,85,81,55,8,95,39]
        // 87
        int nums[] = {33, 95, 93, 21, 58, 91, 65, 87, 55, 70, 29, 81, 89, 67, 58, 29, 68, 84, 4, 51, 87, 74}; //19
        int limit = 87;
        int count = new LongContinuousSubArrWithAbsDiffLessThanEquals().longestSubarray(nums, limit);
        System.out.println(count);
    }

    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxDeque = new LinkedList<>();
        Deque<Integer> minDeque = new LinkedList<>();
        int count = 0;
        int firstIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!minDeque.isEmpty() && nums[i] < nums[minDeque.getLast()]) {
                minDeque.removeLast();
            }
            while (!maxDeque.isEmpty() && nums[i] >= nums[maxDeque.getLast()]) {
                maxDeque.removeLast();
            }
            minDeque.add(i);
            maxDeque.add(i);
            if (Math.abs(nums[minDeque.getFirst()] - nums[maxDeque.getFirst()]) <= limit) {
                count = Math.max(count, 1 + Math.abs(i - firstIndex));
            } else {
                while (nums[i] > nums[minDeque.getFirst()] && Math.abs(nums[minDeque.getFirst()] - nums[maxDeque.getFirst()]) > limit) {
                    firstIndex = minDeque.getFirst() + 1;
                    minDeque.removeFirst();
                }
                while (nums[i] < nums[maxDeque.getFirst()]  && Math.abs(nums[minDeque.getFirst()] - nums[maxDeque.getFirst()]) > limit) {
                    firstIndex = maxDeque.getFirst() + 1;
                    maxDeque.removeFirst();
                }
            }
        }
        return count;
    }
}
