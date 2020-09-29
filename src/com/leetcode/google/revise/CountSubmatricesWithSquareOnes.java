package com.leetcode.google.revise;

// leetcode 1504
public class CountSubmatricesWithSquareOnes {

    public static void main(String[] args) {
        // int[][] mat = {{1, 0, 1}, {1, 1, 0}, {1, 1, 0}};
        int[][] mat = {{0,1,1,1}, {1,1,1,1}, {0,1,1,1}};
        int output = new CountSubmatricesWithSquareOnes().countSquares(mat);
        System.out.println(output);
    }

    public int countSquares(int[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;
        int count = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                int value = matrix[i][j];
                if (value == 0) {
                    continue;
                }
                count++;

                int right = j + 1;
                int down = i + 1;

                int noOfOneInRightSide = 0;

                while (right < col && matrix[i][right] > 0) {
                    noOfOneInRightSide++;
                    right++;
                }
                while (down < row && down <= noOfOneInRightSide && matrix[down][j] > 0) {

                    int diffIndex = down - i;
                    int temp = j;

                    int newPrevRightCount = 0;

                    for (int p = 0; p < noOfOneInRightSide; p++) {
                        if (matrix[down][++temp] > 0) {
                            newPrevRightCount++;
                            if (newPrevRightCount == diffIndex) {
                                count++;
                            }
                        } else {
                            break;
                        }
                    }
                    if (noOfOneInRightSide != newPrevRightCount) {
                        break;
                    }
                    down++;
                }
            }
        }
        return count;
    }
}



