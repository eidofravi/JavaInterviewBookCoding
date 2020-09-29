package com.leetcode.google.revise;

// leetcode 1504
public class CountSubmatricesWithAllOnes {

    public static void main(String[] args) {
       // int[][] mat = {{1, 0, 1}, {1, 1, 0}, {1, 1, 0}};
        int[][] mat = {{1,1,1,1,0},{1,0,0,1,0},{0,0,1,0,1},{0,1,0,0,0}};
        int output = new CountSubmatricesWithAllOnes().numSubmat(mat);
        System.out.println(output);
    }


    int sum = 0;

    public int numSubmat(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int fixedVal = mat[i][j];
                if (fixedVal != 1) {
                    continue;
                }
                count++;
                int rightInd = j + 1;
                int downInd = i + 1;
                int prevRightCount = 0;
                while (rightInd < cols && mat[i][rightInd++] > 0) {
                    prevRightCount++;
                    count++;
                }
                while (downInd < rows && mat[downInd][j] > 0) {
                    int temp = j;
                    count++;
                    int newPrevRightCount = 0;
                    for (int p = 0; p < prevRightCount; p++) {
                        if (mat[downInd][++temp] > 0) {
                            count++;
                            newPrevRightCount++;
                        } else{
                            break;
                        }
                    }
                    prevRightCount = newPrevRightCount;
                    downInd++;
                }
            }
        }
        return count;
    }

}



