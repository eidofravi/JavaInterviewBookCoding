package com.cracking.recursion;

public class DecodeString {

    static int count = 0;

    public static void main(String[] args) {
        int num = new DecodeString().decode("12215");
        System.out.println(num);
    }

    public int decode(String num) {
        if(num.length() == 1 || num.length() == 2) {
            return 1;
        }
        String str1 = num.substring(1);
        String str2 = num.substring(2);
        int total = 1 + decode(str1) + decode(str2);
        return total;
    }
}
