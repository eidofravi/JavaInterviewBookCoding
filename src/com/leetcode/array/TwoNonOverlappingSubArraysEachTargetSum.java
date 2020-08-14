package com.leetcode.array;

import java.util.*;

// working faster 2
public class TwoNonOverlappingSubArraysEachTargetSum {

    public static void main(String[] args) {
        //int arr[] = {5, 5, 4, 4, 5};
       // int arr[] = {7, 3, 4, 7}; // 7 // 2
       //   int arr[] = {2,1,3,3,2,3,1}; // 6 //5
          //int arr[] = {1,6,1}; // 7 //-1
          int arr[] = {1,1,1,2,2,2,4,4}; // 6 // 6
        //int arr[] = {3, 2, 2, 4, 3}; //3 //2
        //  int arr[] = {3,1,1,1,5,1,2,1};
        // int arr[] = {1, 2, 2, 3, 2, 6, 7, 2, 1, 4, 8}; //4
        //int arr[] = {1, 1, 1, 2, 2, 2, 4, 4}; // 6 // 6

        int target = 6;
        //int arr[] = {3, 1, 1, 1, 5, 1, 2, 1};
        //int target = 3;
        System.out.println(new TwoNonOverlappingSubArraysEachTargetSum().minSumOfLengths(arr, target));
    }
  // int arr[] = {1,1,1,2,2,2,4,4}; // 6
    public int minSumOfLengths(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
            map.put(sum, i);
        }
        int ans = Integer.MAX_VALUE;
        sum = 0;

        int leftBest = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if(map.containsKey(sum - target)) {
                leftBest = Math.min(leftBest, i - map.get(sum - target));
            }
            if(leftBest < Integer.MAX_VALUE && map.containsKey(sum + target)) {
                ans = Math.min(ans, leftBest + map.get(sum + target) - i);
            }
        }
        return ans < Integer.MAX_VALUE ? ans : -1;
    }
}

