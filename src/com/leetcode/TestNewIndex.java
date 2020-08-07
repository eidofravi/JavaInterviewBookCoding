package com.leetcode;

public class TestNewIndex {

    public static void main(String[] args) {

       //int[] test = new TestNewIndex().getNewIndex(0, 0, 0, 3, 6);
       int[] test = new TestNewIndex().getNewIndex(2, 1, 1, 2,  1);
        System.out.println(test[0]);
        System.out.println(test[1]);
    }

    private int[] getNewIndex(int i, int j, int min, int max, int move) {
        int arr[] = new int[2];
        for (int num = 0; num < move; num++) {
            if (i == min && j < max) {
                j++;
            } else if (j == max && i < max) {
                i++;
            } else if (i == max && j > min) {
                j--;
            } else if (j == min && i > min) {
                i--;
            }
        }
        arr[0] = i;
        arr[1] = j;
        return arr;
    }
}
