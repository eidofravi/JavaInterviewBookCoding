package com.leetcode;

import java.util.Arrays;

public class NextPermuationFromArray {

    public static void main(String[] args) {

        new NextPermuationFromArray().nextPermutation(new int[]{3, 2, 1});
        //new NextPermuationFromArray().nextPermutation(new int[]{1, 2, 3, 4, 3, 2, 1});
    }

    public void nextPermutation(int[] nums) {
        int endIndex = nums.length - 1;
        boolean sortedReqired = true;
        while (endIndex > 0) {
            if (nums[endIndex] < nums[endIndex - 1] || nums[endIndex] == nums[endIndex - 1]) {
                endIndex--;
                continue;
            } else {
                sortedReqired = false;
                int swapIndex = findIndexForNextNumber(nums[endIndex - 1], nums, endIndex - 1);
                int temp = nums[endIndex - 1];
                nums[endIndex - 1] = nums[swapIndex];
                nums[swapIndex] = temp;
                swap(nums, endIndex);
                break;
            }
        }
        if (sortedReqired) {
            Arrays.sort(nums);
        }
    }

    private int findIndexForNextNumber(int number, int[] nums, int i) {
        int newIndex = 0;
        int minNumber = Integer.MAX_VALUE;
        for (int j = i; j < nums.length; j++) {
            if (nums[j] > number) {
                if (minNumber > nums[j]) {
                    minNumber = nums[j];
                    newIndex = j;
                } else {
                    newIndex = j;
                }
            }
        }
        return newIndex;
    }

    private void swap(int[] nums, int startIndex) {
        int endIndex = nums.length - 1;
        while (startIndex < endIndex + 1) {
            if (nums[startIndex] > nums[endIndex]) {
                int temp = nums[startIndex];
                nums[startIndex] = nums[endIndex];
                nums[endIndex] = temp;
            }
            startIndex++;
            endIndex--;
        }
    }
}
