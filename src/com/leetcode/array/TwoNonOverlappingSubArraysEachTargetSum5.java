package com.leetcode.array;

import java.util.Arrays;

// working fastest
public class TwoNonOverlappingSubArraysEachTargetSum5 {

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
        System.out.println(new TwoNonOverlappingSubArraysEachTargetSum5().minSumOfLengths(arr, target));
    }
  // int arr[] = {1,1,1,2,2,2,4,4}; // 6
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length, ans = Integer.MAX_VALUE, bestSoFar = Integer.MAX_VALUE;
        int[] best = new int[n];
        Arrays.fill(best, Integer.MAX_VALUE);

        int start = 0, sum = 0;
        for(int i = 0; i < n; i++) {
            sum += arr[i];
            while(sum > target) {
                sum -= arr[start];
                start++;
            }
            if(sum == target) {
                if(start > 0 && best[start - 1] < Integer.MAX_VALUE) {
                    ans = Math.min(ans, best[start - 1] + i - start + 1);
                }
                bestSoFar = Math.min(bestSoFar, i - start + 1);
            }
            best[i] = bestSoFar;
        }
        return ans < Integer.MAX_VALUE ? ans : -1;
    }
}

