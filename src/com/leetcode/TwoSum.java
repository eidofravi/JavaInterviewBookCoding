package com.leetcode;

import java.util.Arrays;

public class TwoSum {

    public static void main(String[] args) {
         //int arr[] = {2, 7, 11, 15};
        //int arr[] = {2, 7, 9, 11, 15, 17}; //16
        int arr[] = {3, 2, 4}; //6
        int num[] = new TwoSum().twoSum1(arr, 6);
        System.out.println(num);
    }

    public int[] twoSum1(int[] nums, int target) {
        int[] orgNum = new int[nums.length];
        for (int i = 0 ; i < orgNum.length ; i++) {
            orgNum[i] = nums[i];
        }
        Arrays.sort(nums);
        int startInd = 0;
        int endInd = nums.length - 1;
        int[] data = new int[2];
        int firstNum = 0;
        int secondNum = 0;
        while (endInd > startInd) {
            if (nums[endInd] + nums[startInd] > target) {
                endInd --;
            } else if (nums[endInd] + nums[startInd] < target) {
                startInd++;
            } else {
                firstNum = nums[startInd];
                secondNum = nums[endInd];
                break;
            }
        }
        int k=0;
        for (int i = 0 ; i < orgNum.length ; i++) {
            if (orgNum[i] == firstNum || orgNum[i] == secondNum) {
                data[k++] = i;
            }
        }
        return data;
    }
}