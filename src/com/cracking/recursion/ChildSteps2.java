package com.cracking.recursion;

public class ChildSteps2 {

    public static int count = 0;

    private static class Cell {
        public Cell right;
        public Cell down;
    }

    public static void main(String[] args) {
        int paths = new ChildSteps2().uniquePaths(7, 3);
        System.out.println("paths " + paths);
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