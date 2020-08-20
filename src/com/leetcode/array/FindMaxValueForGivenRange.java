package com.leetcode.array;

import java.util.Deque;
import java.util.LinkedList;

public class FindMaxValueForGivenRange {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6, 6, 7};
        Deque deque = new LinkedList();
        int startIndex = 0;
        int range = 3;

        for (int i = 0; i < arr.length; i++) {

            if (!deque.isEmpty() && i> range - 1 && (int) deque.getFirst() < (i - startIndex)) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && arr[i] >= arr[(int) deque.getLast()]) {
                deque.removeLast();
            }
            deque.add(i);

            if (i - startIndex == range - 1) {
                System.out.println(arr[(int) deque.getFirst()]);
                startIndex++;
            }
        }
    }
}
