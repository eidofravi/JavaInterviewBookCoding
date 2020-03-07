package com.cracking.recursion;

public class RobotInGrid {

    private static class Cell {
        public Cell right;
        public Cell down;
        public String name;

        public Cell(Cell right, Cell down, String name) {
            this.right = right;
            this.down = down;
            this.name = name;
        }
    }

    public static void main(String[] args) {
        Cell cell9= new Cell(null, null, "cell9");
        Cell cell8= new Cell(cell9, null, "cell8");
        Cell cell7= new Cell(cell8, null, "cell7");
        Cell cell6= new Cell(null, cell9, "cell6");
        Cell cell3= new Cell(null, cell6, "cell3");
        Cell cell5= new Cell(cell6, cell8, "cell5");
        Cell cell4= new Cell(cell5, cell7, "cell4");
        Cell cell2= new Cell(cell3, cell5, "cell2");
        Cell cell1= new Cell(cell2, cell4, "cell1");
        new RobotInGrid().reachToDest(cell1);
    }

    private Cell reachToDest(Cell cell) {
        if (cell.right == null && cell.down == null) {
            System.out.println(cell.name);
            return cell;
        }
        System.out.println(cell.name);
        if (null != cell.right)
        reachToDest(cell.right);

        if (null != cell.down)
        reachToDest(cell.down);
        return cell;
    }
}
