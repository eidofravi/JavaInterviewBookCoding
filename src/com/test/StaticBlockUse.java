package com.test;

public class StaticBlockUse {
    private static int var1;
    static {
        var1 = 10;
    }
    public static void main(String args[]) {
        System.out.println("value set by static block for var1 = " + var1);
    }
}
