package com.leetcode.graph;

import java.util.ArrayList;
import java.util.List;

// continue from DFSTraverse2
// how to know which nodes are added bidirectional
// if we add line  list.get(el[1]).add(el[0]); we can traverse from all nodes, see example 21
// but we don't know which node was added in opposite direction, lets find out

public class DFSTraverse3 {
    public static void main(String[] args) {
        int connections[][] = {{0, 6}, {6, 3}, {1, 3}, {2, 1}, {4, 0}, {4, 5}};
        int num = 7;
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] el : connections) {
            list.get(el[0]).add(el[1]);
            list.get(el[1]).add(-el[0]);
        }
        int finalval = new DFSTraverse3().findReverseNode(list, new boolean[7], 0);
        System.out.println(finalval);

    }

    int count = 0;

    private int findReverseNode(List<List<Integer>> list, boolean[] visited, int root) {
        doDFS(list, new boolean[7], 0);
        return count;
    }

    private void doDFS(List<List<Integer>> list, boolean[] visited, int root) {
        visited[root] = true;
        for (int dest : list.get(root)) {
            boolean isNegtive = dest < 0;
            dest = Math.abs(dest);
            if (!visited[dest]) {
                if (isNegtive) {
                    count++;
                }
                doDFS(list, visited, dest);
            }
        }
    }
}
