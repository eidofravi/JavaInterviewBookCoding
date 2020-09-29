package com.leetcode.google.revise;

import java.util.ArrayList;
import java.util.List;

public class ReorderRoutesToMakeAllPathsLeadToTheCityZero {

    public static void main(String[] args) {
        int n = 6;
        int[][] connections = {{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}};
        int output = new ReorderRoutesToMakeAllPathsLeadToTheCityZero().minReorder(n, connections);
        System.out.println(output);
    }


    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        int max = 0;
        for (int[] el : connections) {
            list.get(el[1]).add(el[0]);
            list.get(el[0]).add(-el[1]);
            max = Math.max(max, el[0]);
            max = Math.max(max, el[1]);
        }
        boolean visited[] = new boolean[max + 1];
        return visitNodes(list, 0, visited, 0);
    }

    public int visitNodes(List<List<Integer>> list, int root, boolean visited[], int count) {
        visited[root] = true;
        for (int el : list.get(root)) {
            int absel = Math.abs(el);
            if (!visited[absel]) {
                if (el < 0) {
                    count++;
                }
                count = visitNodes(list, absel, visited, count);
            }
        }
        return count;
    }
}
