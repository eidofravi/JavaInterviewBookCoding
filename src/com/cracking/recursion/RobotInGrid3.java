package com.cracking.recursion;

public class RobotInGrid3 {

    static int count = 0;

    public static void main(String[] args) {
        int num = new RobotInGrid3().uniquePaths(7, 3);
        System.out.println(num);
    }

    public int uniquePaths(int i, int j) {
        int[][] memo = new int[i][j];
        return uniquePaths1(i, j, memo);
    }


    public int uniquePaths1(int i, int j, int[][] memo) {

        if (i == 1 || j == 1) {
            return 1;
        }
        if (memo[i-1][j-1] != 0) {
            return memo[i-1][j-1];
        }
        int result = uniquePaths1(i - 1, j, memo) + uniquePaths1(i, j - 1, memo);
        memo[i-1][j-1] = result;

        return result;
    }
}
