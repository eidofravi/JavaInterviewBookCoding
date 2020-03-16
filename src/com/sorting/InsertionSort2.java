package com.sorting;

public class InsertionSort2 {
    public static void main(String[] args) {
       // int arr[] = new int[]{4, 6, 8, 3, 9, 5, 2, 1};
        int arr[] = new int[]{4, 6, 8, 5, 9, 5, 2, 1};
        new InsertionSort2().sortNumbers(arr);
    }

    private void sortNumbers(int[] arr) {
        if(arr.length == 1 || arr.length == 0) {
            return;
        }
        for (int i = 0; i < arr.length ; i++) {
            int temp = arr[i]; // i = 3
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > temp) {
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
