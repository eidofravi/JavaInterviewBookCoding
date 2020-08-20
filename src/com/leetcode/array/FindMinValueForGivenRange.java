package com.leetcode.array;

import java.util.Deque;
import java.util.LinkedList;

public class FindMinValueForGivenRange {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        Deque deque = new LinkedList();
        int range = 3;

        for (int i = 0; i < arr.length; i++) {
            if (i > 2 && !deque.isEmpty()) {
                if ((i - range + 1) > (int) deque.getFirst()) {
                    deque.removeFirst();
                }
            }
            if (deque.isEmpty()) {
                deque.add(i);
                continue;
            }
            while (!deque.isEmpty() && arr[i] <= arr[(int) deque.getLast()]) {
                deque.removeLast();
            }
            if (!deque.isEmpty() && arr[i] > arr[(int) deque.getLast()] || deque.isEmpty()) {
                deque.addLast(i);
            }
            if (i > 1 && !deque.isEmpty()) {
                System.out.println(arr[(int) deque.getFirst()]);
            }
        }
    }
}
