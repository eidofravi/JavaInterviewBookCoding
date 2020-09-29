package com.leetcode.array.twodimarray;

import java.util.ArrayList;
import java.util.List;

public class PathWithMaxMinValue2 {

    public static void main(String[] args) {
        int input[][] = {{5, 4, 5}, {1, 2, 6}, {7, 4, 6}};
        int output = new PathWithMaxMinValue2().maximumMinimumPath(input);
    }


    public int maximumMinimumPath(int[][] A) {

        int row = A.length;
        int col = A[0].length;
        boolean[][] visited = new boolean[row][col];

        int i = 0;
        int j = 0;
        int min = 0;
        List<List<Integer[][]>> list = new ArrayList<>();
       // list.get


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
                if (A[i + 1][j] > A[i][j - 1] && !visited[i +  1][j]) {
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
            }

        }


        return 0;
    }
}
