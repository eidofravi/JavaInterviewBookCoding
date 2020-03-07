package com.leetcode;

public class RemoveDuplicateFromSortedArray {

    public static void main(String[] args) {

        int area = new RemoveDuplicateFromSortedArray().removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4});
        System.out.println(area);
    }

    public int removeDuplicates(int[] nums) {
        int stIndex = 0;
        int finalLen = 1;
        int indexOcc = 0;
        while (stIndex < nums.length - 1) {
            if (nums[stIndex] != nums[stIndex + 1]) {
                nums[++indexOcc] =  nums[stIndex + 1];
                finalLen++;
            }
            stIndex++;
        }
        return finalLen;

    }

}
