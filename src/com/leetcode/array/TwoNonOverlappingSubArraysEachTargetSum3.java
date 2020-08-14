package com.leetcode.array;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class TwoNonOverlappingSubArraysEachTargetSum3 {

    public static void main(String[] args) {
        //int arr[] = {5, 5, 4, 4, 5};
        int arr[] = {7,3,4,7}; // 7 // 2
        //int arr[] = {3, 2, 2, 4, 3}; //3 //2
        //  int arr[] = {3,1,1,1,5,1,2,1};
        // int arr[] = {1, 2, 2, 3, 2, 6, 7, 2, 1, 4, 8}; //4
        //int arr[] = {1, 1, 1, 2, 2, 2, 4, 4}; // 6 // 6

        int target = 7;
        //int arr[] = {3, 1, 1, 1, 5, 1, 2, 1};
        //int target = 3;
        System.out.println(new TwoNonOverlappingSubArraysEachTargetSum3().minSumOfLengths(arr, target));
    }

    public int minSumOfLengths(int[] arr, int target) {
        int[] num = new int[arr.length];
        Deque<Integer> deque = new LinkedList<>();
        int sum = 0;
        int count = 0;
        int startIndex = 0;
        while (startIndex < arr.length) {
            if (arr[startIndex] == target || sum == target) {
                int size = 1;
                if (!deque.isEmpty()) {
                    size = deque.size();
                    deque.clear();
                }
                num[count++] = size;
                sum = 0;
                startIndex++;

            } else if (sum < target) {
                deque.push(arr[startIndex]);
                sum = sum + arr[startIndex];
                if (sum  < target) {
                    startIndex++;
                }
            } else if (sum > target) {
                int last = deque.removeLast();
                sum = sum - last;
                if (sum < target) {
                    startIndex++;
                }
            }
        }
        Arrays.sort(num);
        int result = 0;
        int valid = 0;
        for (int temp : num) {
            if (temp != 0) {
                if (valid < 2) {
                    valid++;
                    result = result + temp;
                }
            }
        }
        return result > 0 && valid == 2 ? result : -1;
    }
}
