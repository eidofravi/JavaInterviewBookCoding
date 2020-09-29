package com.leetcode.array.twodimarray;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class PathWithMaxMinValue {

    public static void main(String[] args) {
        // int input[][] = {{5, 4, 5}, {1, 2, 6}, {7, 4, 6}};
        int input[][] = {{2,1,3,0,1},{0,2,1,1,2},{2,2,1,1,1},{0,3,0,3,2},{0,3,3,1,1},{3,1,1,3,0}};
        int output = new PathWithMaxMinValue().maximumMinimumPath(input);
        System.out.println(output);
    }

    int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public int maximumMinimumPath(int[][] A) {
        int m = A.length;
        int n = A[0].length;

      //  PriorityQueue<int[]> maxHeap =
        //        new PriorityQueue<>((a, b) -> b[2] - a[2]);
        Deque<int[]> deque = new LinkedList<>();

      //  maxHeap.add(new int[]{0, 0, A[0][0]});
        deque.add(new int[]{0, 0, A[0][0]});
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;

        int res = A[0][0];
        while (!deque.isEmpty()) {
            //int[] cur = maxHeap.poll();
            int[] cur = getMaxValue(deque);
            System.out.println(cur[2]);
            res = Math.min(res, cur[2]);
            if (cur[0] == m - 1 && cur[1] == n - 1) {
                return res;
            }

            for (int[] dir : dirs) {
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];
                if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y]) {
                    continue;
                }

                visited[x][y] = true;
                //maxHeap.add(new int[]{x, y, A[x][y]});
                addValueToQueue(new int[]{x, y, A[x][y]} , deque);

            }
        }
        return res;
    }

    private int[] getMaxValue(Deque<int[]> deque) {
        return deque.removeFirst();
    }

    private void addValueToQueue(int[] value, Deque<int[]> deque) {
        while (!deque.isEmpty() && deque.getLast()[2] < value[2]) {
            deque.removeLast();
        }
        deque.addLast(value);
    }
}
