package com.test;

public class OverloadedMainMethod {
    public static void main(String args[]) {
        System.out.println("main method 1 called");
    }
    public static void main() {
        System.out.println("main method 2 called");
    }
    public void main(int a) {
        System.out.println("main method 3 called");
    }
}
