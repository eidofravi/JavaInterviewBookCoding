package com.leetcode.array;

import java.util.ArrayList;
import java.util.List;

interface BinaryMatrix {
    public int get(int row, int col);

    public List<Integer> dimensions();
}

class BinaryMatrixImpl implements BinaryMatrix {

    //int[][] data = {{0, 0}, {1, 1}};
    int[][] data = {{0, 0}, {0, 0}};
    //int[][] data = {{0, 0}, {0, 1}};
    // int[][] data = {{0, 0, 0, 0, 1, 1}, {0, 0, 0, 1, 1, 1}, {0, 0, 0, 0, 1, 1}, {0, 0, 0, 0, 1, 1}, {0, 0, 0, 1, 1, 1}, {0, 0, 0, 1, 1, 1}};

    @Override
    public int get(int row, int col) {
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

public class LeftMostColumnWithAtleastOne {

    public static void main(String[] args) {
        BinaryMatrix binaryMatrix = new BinaryMatrixImpl();
        System.out.println(new LeftMostColumnWithAtleastOne().leftMostColumnWithOne(binaryMatrix));
    }

    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimensions = binaryMatrix.dimensions();

        int rows = dimensions.get(0);
        int cols = dimensions.get(1);

        int startRowIndex = 0;
        int lastColIndex = cols - 1;
        int returnIndex = -1;

        while (startRowIndex < rows && lastColIndex >= 0) {
            if (binaryMatrix.get(startRowIndex, lastColIndex) == 0) {
                startRowIndex++;
            } else {
                returnIndex = lastColIndex;
                lastColIndex--;

            }
        }
        return returnIndex;
    }
}
