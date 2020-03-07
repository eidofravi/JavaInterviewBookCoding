package com.leetcode;

public class RemoveElementFromArray {

    public static void main(String[] args) {

        int area = new RemoveElementFromArray().removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2);
        System.out.println(area);
    }

    public int removeElement(int[] nums, int val) {
        int stIndex = 0;
        int nextIndex = 0;
        while (stIndex < nums.length) {
            if (nums[stIndex] != val) {
                nums[nextIndex++] = nums[stIndex];
            }
            stIndex++;
        }
        return nextIndex;
    }
}
