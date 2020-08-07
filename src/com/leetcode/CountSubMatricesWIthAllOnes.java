package com.leetcode;

public class CountSubMatricesWIthAllOnes {

    public static void main(String[] args) {
        int mat[][] = {{0, 1, 1, 0}, {0, 1, 1, 1}, {1, 1, 1, 0}};
        int rows = mat.length;
        int col = mat[0].length;
        int count = 0;
        int rightCount = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {

                int down = i;

                // move right
                int prevIterCount = col - j;
                while (down < rows) {
                    int val = mat[down][j];
                    if (val == 1) {
                        count++;
                        int loopcount = 0;
                        for (int r = j + 1; r < col; r++) {
                            if (loopcount < prevIterCount) {
                                loopcount++;
                                int rightVal = mat[down][r];
                                if (rightVal == 1) {
                                    rightCount++;
                                } else {
                                    break;
                                }
                            }
                        }
                        prevIterCount = rightCount;
                        down++;
                        count = count + rightCount;
                        rightCount = 0;
                    } else {
                        break;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
