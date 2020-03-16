package com.sorting;

public class SelectionSort {
    public static void main(String[] args) {
        int arr[] = new int[]{3, 5, 2, 7, 9, 5, 2, 1};
        new SelectionSort().sortNumbers(arr);
    }

    private void sortNumbers(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            findMinimumAndSwap( arr, i);
        }
    }

    private void findMinimumAndSwap(int[] arr, int index) {
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int i = index; i < arr.length ; i++) {
            if (arr[i] < min) {
                min = arr[i];
                minIndex = i;
            }
        }
        int temp = arr[index];
        arr[index] = arr[minIndex];
        arr[minIndex] = temp;
    }
}
