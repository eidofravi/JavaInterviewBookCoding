package com.leetcode;

import java.util.*;

public class _1446ReorderRoutestToCityZero2 {
    public static void main(String[] args) {
        int n = 9;
        //int connections[][] = {{1, 0}, {2, 0}};
        // int connections[][] = {{1,0},{1,2},{3,2},{3,4}};
        //  int connections[][] = {{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}}; // 3
        // int connections[][] = {{1,0},{1,2},{2,3},{4,2}};
       // int connections[][] = {{4, 3}, {2, 3}, {1, 2}, {1, 0}}; // 2
        int connections[][] = {{0,6},{6,3},{1,3},{2,1},{4,0},{4,5}};
        //int connections[][] = {{0, 1}, {2, 0}, {3, 2}}; // 1
        int count = new _1446ReorderRoutestToCityZero2().minReorder(n, connections);
        System.out.println(count);
    }


    public int minReorder(int n, int[][] connections) {
        int count = 0;
        Set<Integer> path = new HashSet<>();
        path.add(0);
        Arrays.sort(connections, (a, b) -> a[1] - b[1]);
        List<int[]> leftconnections = new ArrayList<>();

        for (int[] con : connections) {
            if (path.contains(con[1])) {
                path.add(con[0]);
            } else if (path.contains(con[0])) {
                path.add(con[1]);
                count++;
            } else {
                leftconnections.add(con);
            }
        }

        for (int[] left : leftconnections) {
            if (path.contains(left[0])) {
                path.add(left[1]);
                count++;
            } else if (path.contains(left[1])) {
                path.add(left[0]);
            }
        }

        return count;
    }

}
