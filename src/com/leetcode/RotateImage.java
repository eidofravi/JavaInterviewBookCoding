package com.leetcode;

public class RotateImage {

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
        new RotateImage().rotate(matrix);

    }

    public void rotate(int[][] matrix) {
        int matrixLen = matrix.length;
        int sizeGrid = matrixLen;
        int initFirstIndex = -1;
        int initsecondIndex = -1;
        int minBoundary = -1;
        int maxBoundary =  sizeGrid;
        int rotate = 3;
        while (sizeGrid > 1) {

            initFirstIndex++;
            initsecondIndex++;
            minBoundary++;
            maxBoundary--;

            for (int secondInd = initsecondIndex; secondInd < maxBoundary; secondInd++) {

                swapValue1(matrix, initFirstIndex, secondInd, sizeGrid, minBoundary, maxBoundary, rotate);
            }
            sizeGrid = sizeGrid - 2;
        }
        System.out.println(matrix);
    }

    private void swapValue1(int[][] matrix, int firstIndex, int secondIndex, int sizeGrid, int minBoundary, int maxBoundary, int rotate) {
        int move = 0;
        for (int i = 0; i < rotate; i++) {
            move = (sizeGrid - 1) * (i + 1);
            int[] newIndex = getNewIndex(firstIndex, secondIndex, minBoundary, maxBoundary, move);

            int temp = matrix[firstIndex][secondIndex];
            matrix[firstIndex][secondIndex] = matrix[newIndex[0]][newIndex[1]];
            matrix[newIndex[0]][newIndex[1]] = temp;
        }
    }

    private int[] getNewIndex(int i, int j, int min, int max, int move) {
        int arr[] = new int[2];
        for (int num = 0; num < move; num++) {
            if (i == min && j < max) {
                j++;
            } else if (j == max && i < max) {
                i++;
            } else if (i == max && j > min) {
                j--;
            } else if (j == min && i > min) {
                i--;
            }
        }
        arr[0] = i;
        arr[1] = j;
        return arr;
    }
}
