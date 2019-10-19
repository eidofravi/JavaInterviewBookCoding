package com.test.one;

public class CompareStringEquality {
    public static void main(String[] args) {
        String str1 = "hello";
        String str2 = "world";
        String str3 = "hello";
        String str4 = new String("hello");
        String str5 = new String("hello").intern();

        System.out.println("str1.equals(str2) : " + str1.equals(str2));
        System.out.println("str1 == str2 : " + (str1 == str2));
        System.out.println("str1.equals(str3) : " + str1.equals(str3));
        System.out.println("str1 == str3 : " + (str1 == str3));
        System.out.println("str1.equals(str4) : " + str1.equals(str4));
        System.out.println("str1 == str4 : " + (str1 == str4));
        System.out.println("str1.equals(str5) : " + str1.equals(str5));
        System.out.println("str1 == str5 : " + (str1 == str5));
        System.out.println("str4.equals(str5) : " + str4.equals(str5));
        System.out.println("str4 == str5 : " + (str4 == str5));
    }
}
