package com.leetcode;

public class RotateImage2 {

    public static void main(String[] args) {
       /* int matrix[][] = new int[4][4];
        matrix[0][0]= 5;
        matrix[0][1]= 1;
        matrix[0][2]= 9;
        matrix[0][3]= 11;

        matrix[1][0]= 2;
        matrix[1][1]= 4;
        matrix[1][2]= 8;
        matrix[1][3]= 10;

        matrix[2][0]= 13;
        matrix[2][1]= 3;
        matrix[2][2]= 6;
        matrix[2][3]= 7;

        matrix[3][0]= 15;
        matrix[3][1]= 14;
        matrix[3][2]= 12;
        matrix[3][3]= 16;*/
        int matrix[][] = {{1,2,3},{4,5,6},{7,8,9}};
        new RotateImage2().rotate(matrix);

    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < Math.ceil(((double) n) / 2.); j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = temp;
            }
        }
        System.out.println(matrix);
    }

}
