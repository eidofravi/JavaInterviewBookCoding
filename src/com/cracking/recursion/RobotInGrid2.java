package com.cracking.recursion;

public class RobotInGrid2 {

    static int count = 0;

    public static void main(String[] args) {

        int num = new RobotInGrid2().uniquePaths(7,3);
        int[][] arr = new int[7][3 ];
        System.out.println(arr.length);
        System.out.println(arr[1].length);
        System.out.println(count);
    }

    public int uniquePaths(int m, int n) {
        if (m==1 && n==1) {
            ++count;
        }
        if(n>0)
        uniquePaths(m,  n-1);
        if(m>0)
        uniquePaths(m-1,  n);
        return count;
    }
}
