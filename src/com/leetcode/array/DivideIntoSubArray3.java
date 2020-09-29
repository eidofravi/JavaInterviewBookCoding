package com.leetcode.array;

import java.util.*;

public class DivideIntoSubArray3 {

    public static void main(String[] args) {

       /* int[] nums = {1,2,3,3,4,4,5,6};
        int k = 4;*/
        //int[] nums = {3, 3, 2, 2, 1, 1};
         //int[] nums = {2, 4, 6};
       //  int[] nums = {3,2,1,2,3,4,3,4,5,9,10,11};
       // int k = 3;
        int[] nums = {16,5,15,15,20,16,20,14,21,20,19,20,12,17,13,15,11,17,18,18,11,13,13,14,14,9,20,18,10,4,4,6,15,19,8,15,7,17,15,9,24,2,23,22,26,8,21,22,14,13,16,2,25,23,17,19,17,3,22,23,19,12,21,12,16,27,28,10,
                13,8,24,3,22,6,10,9,14,7,11,22,11,5,16,19,21,2,8,24,16,21,7,29,18,9,10,18,6,17,21,20};
        int k = 10;
        boolean output = new DivideIntoSubArray3().isPossibleDivide(nums, k);
        System.out.println(output);
    }

    public boolean isPossibleDivide(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();

        if (nums.length % k != 0 || nums.length < k) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            if (null != map.get(nums[i])) {
                int value = map.get(nums[i]);
                map.put(nums[i], value + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        for (int i = 0; i < nums.length - k; i++) {
            if (null == map.get(nums[i])) {
                continue;
            }
            for (int j = 0; j < k; j++) {
                int key = nums[i] + j;
                if (map.size() > 0 && null != map.get(key)) {
                    int value = map.get(key);
                    if (value > 1) {
                        map.put(key, value - 1);
                    } else {
                        map.remove(key);
                    }
                }
            }
        }

        return map.isEmpty();
    }
}
