package com.leetcode.graph;

import java.util.ArrayList;
import java.util.List;

// print all nodes of a graph, in below example this will not print because these are not directed graph or I can say not directed in one direction
// at some point it break the graph and there is no way to reach to another node.
// to overcome this problem I would create a new class DFSTraverse2.java
public class DFSTraverse1 {
    public static void main(String[] args) {
        int connections[][] = {{0, 6}, {6, 3}, {1, 3}, {2, 1}, {4, 0}, {4, 5}};
        int num = 7;
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] el : connections) {
            list.get(el[0]).add(el[1]);
        }
        new DFSTraverse1().doDFS(list, new boolean[7], 0);

    }

    private void doDFS(List<List<Integer>> list, boolean[] visited, int root) {
        visited[root] = true;
        System.out.println(root);

        for (int dest : list.get(root)) {
            if (!visited[dest]) {
                doDFS(list, visited, dest);
            }
        }
    }
}
