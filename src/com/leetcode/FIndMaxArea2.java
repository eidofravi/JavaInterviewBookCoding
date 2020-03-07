package com.leetcode;

public class FIndMaxArea2 {

    public static void main(String[] args) {

        int area = new FIndMaxArea2().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        System.out.println(area);
    }

    public int maxArea(int[] height) {
        int stIndex = 0;
        int endIndex = height.length - 1;
        int maxArea = 0;

        while (endIndex > stIndex) {
            int tempArea = (endIndex - stIndex) * Math.min(height[stIndex], height[endIndex]);
            maxArea = Math.max(maxArea, tempArea);

            if (height[endIndex] > height[stIndex]) {
                stIndex++;
            } else {
                endIndex--;
            }

        }
        return maxArea;

    }

}
