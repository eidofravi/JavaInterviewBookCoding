package com.leetcode.array.twodimarray;

public class PathWithMaxMinValue3 {

    public static void main(String[] args) {
        int input[][] = {{5, 4, 5}, {1, 2, 6}, {7, 4, 6}};
        int output = new PathWithMaxMinValue3().maximumMinimumPath(input);
    }


    public int maximumMinimumPath(int[][] A) {

        int row = A.length;
        int col = A[0].length;
        boolean[][] visited = new boolean[row][col];

        int i = 0;
        int j = 0;
        int min = 0;


        while (i < row - 1 && j < col - 1) {
            int num = A[i][j];
            if (i == 0 && j == 0) {
                if (A[i][j + 1] > A[i + 1][j] && !visited[i][j + 1]) {
                    min = Math.min(min, A[i][j + 1]);
                    visited[i][j + 1] = true;
                    j++;
                } else if (!visited[i + 1][j]) {
                    min = Math.min(min, A[i + 1][j]);
                    visited[i + 1][j] = true;
                    i++;
                } else {
                    break;
                }
            } else if (i == 0 && j == col - 1) {
                if (A[i + 1][j] > A[i][j - 1] && !visited[i + 1][j]) {
                    min = Math.min(min, A[i + 1][j]);
                    visited[i + 1][j] = true;
                    i++;
                } else if (!visited[i][j - 1]) {
                    min = Math.min(min, A[i][j - 1]);
                    visited[i][j - 1] = true;
                    j--;
                } else {
                    break;
                }
            } else if (i == row - 1 && j == 0) {
                if (A[i - 1][j] > A[j + 1][i] && !visited[i - 1][j]) {
                    min = Math.min(min, A[i - 1][j]);
                    visited[i - 1][j] = true;
                    i--;
                } else if (!visited[j + 1][i]) {
                    min = Math.min(min, A[j + 1][i]);
                    visited[j + 1][i] = true;
                    j++;
                } else {
                    break;
                }
            } else if (i == 0) {
                int newI = i;
                int newJ = j;
                if (A[j - 1][i] > A[j + 1][i]) {

                }

            } else if (j == 0) {

            } else if (i == row - 1) {

            } else if (j == col - 1) {

            } else {

            }

        }


        return 0;
    }
}
