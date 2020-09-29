package com.leetcode.array.twodimarray;

import java.util.Deque;
import java.util.LinkedList;

public class RemoveAdjacentDuplicatesString2 {

    public static void main(String[] args) {
        String str = "deeedbbcccbdaa";
        int k = 3;
        String s = new RemoveAdjacentDuplicatesString2().removeDuplicates(str, k);
        System.out.println(s);
    }



    public String removeDuplicates(String s, int k) {

        if (s.length() < k) {
            return s;
        }

        Deque<Character> queue = new LinkedList();
        boolean digitRemoved = true;
        int counter = 0;

        while(digitRemoved) {
            boolean tempDigitRemoved = false;
            for (int i = 0 ; i < s.length(); i++) {
                Character ch = s.charAt(i);
                if (queue.isEmpty()) {
                    queue.add(ch);
                    counter++;
                } else {
                    Character last = queue.getLast();
                    if (last == ch) {
                        counter++;
                        queue.add(ch);
                        if (counter == k) {
                            for (int j = 0 ; j < k ; j++) {
                                queue.removeLast();
                            }
                            tempDigitRemoved = true;
                        }
                    } else {
                        counter = 1;
                        queue.add(ch);
                    }
                }
            }
            StringBuilder sb  = new StringBuilder();
            while(!queue.isEmpty()) {
                sb.append(queue.removeFirst());
            }
            s = sb.toString();
            counter = 0;
            digitRemoved = tempDigitRemoved;
        }
        return s;
    }
}
