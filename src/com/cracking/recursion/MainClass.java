package com.cracking.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {

    public static int count = 0;

    private static class Cell {
        public Cell right;
        public Cell down;
    }
   
    public int uniquePaths(int m, int n) {

        Cell[][] cellArr = new Cell[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cellArr[i][j] = new Cell();
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Cell cell = cellArr[i][j];
                if(j != n-1)
                    cell.right = cellArr[i][j+1];

                if(i != m-1)
                    cell.down = cellArr[i+1][j];
            }
        }

        reachToDest(cellArr[0][0]);
        return count;
    }

    private Cell reachToDest(Cell cell) {
        if (cell.right == null && cell.down == null) {
            ++count;
            return cell;
        }
        if (null != cell.right)
            reachToDest(cell.right);

        if (null != cell.down)
            reachToDest(cell.down);
        return cell;
    }
}

public class MainClass {
    public static void main(String[] args)  {
        int ret = new Solution().uniquePaths(3, 7);
    System.out.print(ret);
    }
}