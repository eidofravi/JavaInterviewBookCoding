package com.leetcode;

public class LongestContinuousSubarray {
    public static void main(String[] args) {
        int arr[] = {4,8,5,1,7,9};
        System.out.println(new Solution().longestSubarray(arr, 6));
    }
}

class Solution {
    public int longestSubarray(int[] nums, int limit) {
        if (nums.length == 1) {
            return 1;
        }
        int finalCount = 0;
        int endIndex = 0;
        for (int i = 0 ; i < nums.length; i++) {
            endIndex = i + 1;
            boolean notSkip = true;
            while(endIndex < nums.length && notSkip) {
                int differnum = Math.abs(findLowestNumber(nums, i, endIndex++));
                if (differnum <= limit) {
                    finalCount = Math.max(finalCount, endIndex-i);
                } else {
                    notSkip = false ;
                }
            }
        }
        return finalCount;
    }

    private int findLowestNumber(int[] arr, int startIndex, int endIndex) {
        int lowest = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = startIndex ; i <= endIndex; i++) {
            lowest = Math.min(lowest, arr[i]) ;
            max = Math.max(max, arr[i]);
        }
        return max - lowest;
    }
}
