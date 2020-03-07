package com.cracking.recursion;

public class ChildSteps {

    static int count = 0;

    public static void main(String[] args) {
        new ChildSteps().countSteps(4);
        System.out.println(count);
    }

    private void countSteps(int num) {
        if (num == 0) {
            ++ count;
            return;
        }
        if (num < 0) {
            return;
        }
        countSteps(num - 1);
        countSteps(num - 2);
        countSteps(num - 3);
    }
}
