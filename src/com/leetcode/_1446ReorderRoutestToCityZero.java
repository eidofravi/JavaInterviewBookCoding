package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _1446ReorderRoutestToCityZero {
    public static void main(String[] args) {
        int n = 6;
        //int connections[][] = {{1, 0}, {2, 0}};
        // int connections[][] = {{1,0},{1,2},{3,2},{3,4}};
          int connections[][] = {{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}}; // 3
        // int connections[][] = {{1,0},{1,2},{2,3},{4,2}};
        //int connections[][] = {{4, 3}, {2, 3}, {1, 2}, {1, 0}}; // 2
       // int connections[][] = {{0, 1}, {2, 0}, {3, 2}}; // 1
        int count = new _1446ReorderRoutestToCityZero().minReorder(n, connections);
        System.out.println(count);
    }


    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> el = new ArrayList<>();
        for (int  i = 0  ; i < n ; i++) {
            el.add(new ArrayList<>());
        }
        for (int [] c : connections) {
            el.get(c[0]).add(c[1]);
            el.get(c[1]).add(-c[0]);
        }
        return doDFS(el, new boolean[n], 0);
    }

    private int doDFS(List<List<Integer>> el, boolean[] visited, int root) {
        int count = 0 ;
        visited[root] = true;
        for (int dest : el.get(root)) {
            if (!visited[Math.abs(dest)]) {
                count = count + doDFS(el, visited, Math.abs(dest)) + ((dest > 0) ? 1:0);
            }
        }
        return count;
    }

}
