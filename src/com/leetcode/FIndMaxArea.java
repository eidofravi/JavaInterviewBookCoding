package com.leetcode;

public class FIndMaxArea {

    public static void main(String[] args) {

        int area = new FIndMaxArea().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        System.out.println(area);
    }

    public int maxArea(int[] height) {
        int stIndex = 0;
        int endIndex = height.length - 1;
        int maxArea = 0;
        int maxLen = height.length - 1;

        while (endIndex > stIndex) {
            int num = Math.min(height[stIndex], height[endIndex]);
            int tempArea = num * maxLen;
            maxArea = Math.max(maxArea, tempArea);

            if (height[endIndex] > height[stIndex]) {
                stIndex++;
                maxLen--;
            } else if (height[endIndex] < height[stIndex]) {
                endIndex--;
                maxLen--;
            } else {
                stIndex++;
                endIndex--;
                maxLen--;
                maxLen--;
            }

        }
        return maxArea;

    }

}
