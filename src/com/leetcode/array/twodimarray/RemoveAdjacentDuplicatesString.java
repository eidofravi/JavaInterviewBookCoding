package com.leetcode.array.twodimarray;

import java.util.Deque;
import java.util.LinkedList;

public class RemoveAdjacentDuplicatesString {

    public static void main(String[] args) {
        String str = "deeedbbcccbdaa";
        int k = 3;
        String s = new RemoveAdjacentDuplicatesString().removeDuplicates(str, k);
        System.out.println(s);
    }

    public String removeDuplicates(String s, int k) {

        if (s.length() < k) {
            return s;
        }
        boolean digitRemoved = true;
        int counter = 1;

        while (digitRemoved) {
            boolean tempDigitRemoved = false;
            for (int i = 1; i < s.length(); i++) {
                if (i < 1) {
                    break;
                }
                Character ch1 = s.charAt(i - 1);
                Character ch2 = s.charAt(i);

                if (ch2 != ch1) {
                    counter = 1;
                    continue;
                }
                counter++;
                if (counter == k) {
                    int removeFirstIndex = i - k + 1;
                    StringBuilder sb = new StringBuilder();
                    sb.append(s.substring(0, removeFirstIndex));
                    sb.append(s.substring(i + 1));
                    i = removeFirstIndex - 1;
                    s = sb.toString();
                    tempDigitRemoved = true;
                    counter = 1;
                    //break;
                }
            }
            counter = 1;
            digitRemoved = tempDigitRemoved;
        }
        return s;
    }
}
