package com.test;

public class StringIsImmutable {

    public static void main(String[] args) {
        String str1 = "Hello";

        String str2 = "Hello";
        str1.substring(0,3);

        if (str2.equals(getValueFromDB())) {
            System.out.println("Hello there!");
        } else {
            System.out.println("Hello is changed");
        }
    }

    private static String getValueFromDB() {
        return "Hello";
    }
}
