package com.leetcode.array;

import java.util.Stack;

class Position {
    public int leftIndex;
    public int rightIndex;
    public int currIndex;
    public int value;
}

public class SumOFSubArrayMinimum {


    public static void main(String[] args) {
        int arr[] = {48,87,27};
        //int arr[] = {3,1,2,4};
        int output = new SumOFSubArrayMinimum().sumSubarrayMins(arr);
        System.out.println(output);
    }

    public int sumSubarrayMins(int[] A) {

        int left[] = new int[A.length];
        int right[] = new int[A.length];

        Stack<Integer> stack = new Stack();

        for (int i = 0; i < A.length; i++) {

            while (!stack.isEmpty() && A[stack.peek()] > A[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                if (i == 0) {
                    left[i] = 0;
                } else {
                    left[i] = -1;
                }
                stack.push(i);
                continue;
            }
            left[i] = stack.peek();
            stack.push(i);
        }
        stack = new Stack<>();
        for (int i = A.length - 1; i >= 0; i--) {

            while (!stack.isEmpty() && A[stack.peek()] > A[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                if (i == A.length - 1) {
                    right[i] = i;
                } else {
                    right[i] = A.length;
                }
                stack.push(i);
                continue;
            }
            right[i] = stack.peek();
            stack.push(i);
        }
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            int totalSumArrayForIndex = 0;
            int leftInd = left[i];
            int rightInd = right[i];
            boolean leftNav = false;
            boolean rightNav = false;
            if (i > leftInd) {
                leftNav = true;
            }
            if (rightInd > i) {
                rightNav = true;
            }
            if (leftNav && rightNav) {
                int leftNum = i - leftInd - 1;
                int rightNum = rightInd - i - 1;
                totalSumArrayForIndex = 2 * (leftNum + rightNum);
            } else if (leftNav) {
                totalSumArrayForIndex = i - leftInd;
            } else if (rightNav) {
                totalSumArrayForIndex = rightInd - i;
            }
            sum = sum + totalSumArrayForIndex * A[i];
        }

        return sum;
    }
}
