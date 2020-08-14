package com.leetcode.array;

public class TwoNonOverlappingSubArraysEachTargetSum2 {

    public static void main(String[] args) {
        //int arr[] = {5, 5, 4, 4, 5};
        //int arr[] = {3,2,2,4,3};
        //  int arr[] = {3,1,1,1,5,1,2,1};
        // int arr[] = {1, 2, 2, 3, 2, 6, 7, 2, 1, 4, 8}; //4
        int arr[] = {1, 1, 1, 2, 2, 2, 4, 4};

        int target = 6;
        //int arr[] = {3, 1, 1, 1, 5, 1, 2, 1};
        //int target = 3;
        System.out.println(new TwoNonOverlappingSubArraysEachTargetSum2().minSumOfLengths(arr, target));
    }

    public int minSumOfLengths(int[] arr, int target) {
        int firstIndex = 0;
        int secondIndex = 0;
        int firstArrLen = 0;
        int secondArrLen = 0;
        int sum = 0;
        int count = 0;
        while (secondIndex < arr.length) {
            if (sum < target) {
                sum = sum + arr[secondIndex];
                count++;
                if (sum < target) {
                    secondIndex++;
                }
            }
            if (sum > target) {
                sum = sum - arr[firstIndex];
                count--;
                if (sum > target) {
                    firstIndex++;
                }
            }
            if (sum == target) {
                if (firstArrLen == 0) {
                    firstArrLen = count;
                } else if (secondArrLen == 0) {
                    secondArrLen = count;
                } else if (secondArrLen > firstArrLen && secondArrLen > count) {
                    secondArrLen = count;
                } else if (firstArrLen > secondArrLen && firstArrLen > count) {
                    firstArrLen = count;
                }
                secondIndex++;
                firstIndex = secondIndex;
                count = 0;
                sum = 0;
            }
        }
        return firstArrLen > 0 && secondArrLen > 0 ? firstArrLen + secondArrLen : -1;
    }
}
