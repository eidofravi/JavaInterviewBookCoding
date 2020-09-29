package com.leetcode.array.twodimarray;

public class MaxSideLengthOfSquareWithSumThreshold {

    public static void main(String[] args) {
        int mat[][] = {{1, 1, 3, 2, 4, 3, 2}, {1, 1, 3, 2, 4, 3, 2}, {1, 1, 3, 2, 4, 3, 2}};
        int threshold = 4;
        int output = new MaxSideLengthOfSquareWithSumThreshold().maxSideLength(mat, threshold);
        System.out.println(output);
    }

    public int maxSideLength(int[][] mat, int threshold) {
        int rows = mat.length;
        int col = mat[0].length;
        int max = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                int sum = 0;
                int repeat = 0;
                while (sum < threshold && i + repeat < rows && j + repeat < col) {
                    repeat = repeat + 1;
                    sum = sum + sumOfMatrix(i, j, repeat, mat);
                }
                if (sum > threshold) {
                    repeat = repeat - 1;
                }
                max = Math.max(max, repeat);
            }
        }
        return max;
    }

    public int sumOfMatrix(int i, int j, int size, int[][] mat) {
        int sum = 0;
        if (i + size <= mat.length && j + size <= mat[0].length) {
            // down
            for (int k = i; k < i + size; k++) {
                sum = sum + mat[k][j];
            }
            // right
            for (int k = j; k < j + size; k++) {
                sum = sum + mat[i][k];
            }
            sum = sum - mat[i + size - 1][j + size - 1];
        }
        return sum;
    }

}
