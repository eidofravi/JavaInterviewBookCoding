package com.leetcode.graph;

import java.util.ArrayList;
import java.util.List;

public class EmployeeNotification {

    public static void main(String[] args) {
        int manager[] = {-1, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6};
        int informTime[] = {1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0};
        int n = 15;
        int headID = 0;

        int output = new EmployeeNotification().numOfMinutes(n, headID, manager, informTime);
        System.out.println(output);
    }

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < manager.length; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < manager.length; i++) {
            if (manager[i] != -1) {
                list.get(manager[i]).add(i);
            }
        }
        int output = new EmployeeNotification().doDFS(list, new boolean[n], headID, informTime, 0, 0);
        return output;
    }
    //Input: n = 15, headID = 0, manager = [-1,0,0,1,1,2,2,3,3,4,4,5,5,6,6], informTime = [1,1,1,1,1,1,1,0,0,0,0,0,0,0,0]

    private int doDFS(List<List<Integer>> list, boolean[] visited, int root, int[] informTime, int infTime, int finalTime) {
        visited[root] = true;
        if (list.get(root).isEmpty()) {
            finalTime = Math.max(finalTime, infTime);
            return finalTime;
        }
        // System.out.println(root);
        infTime = infTime + informTime[root];
        for (int dest : list.get(root)) {
            if (!visited[dest]) {
                finalTime = doDFS(list, visited, dest, informTime, infTime, finalTime);
            }
        }
        return finalTime;
    }
}
