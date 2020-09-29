package com.leetcode.array;

public class DivideIntoSubArray2 {

    public static void main(String[] args) {

       /* int[] nums = {1,2,3,3,4,4,5,6};
        int k = 4;*/
        int[] nums = {3,3,2,2,1,1};
        int k = 3;
        boolean output = new DivideIntoSubArray2().isPossibleDivide(nums, k);
        System.out.println(output);
    }


    public boolean isPossibleDivide(int[] nums, int k) {



        if (nums.length % k != 0 || nums.length <  k) {
            return false;
        }
        int arr[] = new int[200000];

        for (int i = 0 ; i < nums.length; i++) {
            arr[nums[i]] =  arr[nums[i]] + 1;
        }
        int removed = 0 ;

        for (int i = 0 ; i < arr.length; i++) {
            if (arr[i] > 0) {
                while (arr[i] > 0) {
                    int endAr = i + k;
                    for (int j = i; j < endAr; j++) {
                        arr[j] = arr[j] - 1;
                        if(arr[j] < 0) {
                            return false;
                        }
                        removed++;
                    }
                }
            }
        }
        return removed == nums.length;
    }
}
