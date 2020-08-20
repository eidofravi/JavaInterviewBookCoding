package com.leetcode.array;

import java.util.ArrayList;
import java.util.List;

class BinaryMatrixImpl2 implements BinaryMatrix {

    //int[][] data = {{0, 0}, {1, 1}};
    //int[][] data = {{0, 0}, {0, 1}};
    int[][] data = {{0,0,0,0,1,1},{0,0,0,1,1,1},{0,0,0,0,1,1},{0,0,0,0,1,1},{0,0,0,1,1,1},{0,0,0,1,1,1}};

    @Override
    public int get(int row, int col) {
        System.out.println(row);
        System.out.println(col);
        return data[row][col];
    }

    @Override
    public List<Integer> dimensions() {
        List<Integer> list = new ArrayList<>();
        list.add(data.length);
        list.add(data[0].length);
        return list;
    }
}

public class LeftMostColumnWithAtleastOne2 {

    public static void main(String[] args) {
        BinaryMatrix binaryMatrix = new BinaryMatrixImpl();
        System.out.println(new LeftMostColumnWithAtleastOne().leftMostColumnWithOne(binaryMatrix));
    }

    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimensions = binaryMatrix.dimensions();

        int rows = dimensions.get(0);
        int cols = dimensions.get(1);

        int startColIndex = 0;
        int lastColIndex = cols - 1;
        int previousLastColIndex = lastColIndex;

        int lastRowIndex = rows - 1;
        int startRowIndex = 0;
        boolean foundOne = false;
        int returnIndex = -1;

        while (startRowIndex <= lastRowIndex) {
            if (binaryMatrix.get(startRowIndex, 0) == 1) {
                return 0;
            }
            startRowIndex++;
        }
        while (startColIndex < lastColIndex) {
            startRowIndex = 0;
            foundOne = false;
            while (startRowIndex <= lastRowIndex) {
                if (binaryMatrix.get(startRowIndex, lastColIndex) == 1) {
                    foundOne = true;
                    returnIndex = lastColIndex;
                    previousLastColIndex = lastColIndex;
                    lastColIndex = lastColIndex + ((lastColIndex - startColIndex) / 2);
                    break;
                }
                startRowIndex++;
            }
            if (!foundOne) {
                startColIndex = lastColIndex;
                lastColIndex = previousLastColIndex;
            }
        }
        return returnIndex;
    }
}
