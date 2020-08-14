package com.leetcode.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaximizeYourPoints {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 1};
        int k = 3;
        new MaximizeYourPoints().maxScore(arr, k);
    }


    public int maxScore(int[] cardPoints, int k) {

        int initialSum = 0;

        for (int i = 0; i < k; i++) {
            initialSum = initialSum + cardPoints[i];
        }
        int sum = initialSum;
        int index1 = k - 1;
        int index2 = cardPoints.length - 1;

        while (k > 0) {
            sum = sum + cardPoints[index2--] - cardPoints[index1--];
            initialSum = Math.max(initialSum, sum);
            k--;
        }
        return initialSum;
    }
}
