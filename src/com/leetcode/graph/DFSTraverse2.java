package com.leetcode.graph;

import java.util.ArrayList;
import java.util.List;

// continue from DFSTraverse1
// how to print all node this time
// create double sided nodes and visit node just one time if it already visited
// just adding line no 21, reverse addition of element will print all nodes values
// now next question is how many nodes were redirected
// move to class DFSTraverse3
public class DFSTraverse2 {
    public static void main(String[] args) {
        int connections[][] = {{0, 6}, {6, 3}, {1, 3}, {2, 1}, {4, 0}, {4, 5}};
        int num = 7;
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] el : connections) {
            list.get(el[0]).add(el[1]);
            list.get(el[1]).add(el[0]);
        }
        new DFSTraverse2().doDFS(list, new boolean[7], 0);

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
