package com.String;

public class ConvertACharToString {
    public static void main(String[] args) {
        char ch = 'c';
        char[] chArr = {ch};
        String str = new String(chArr);
        System.out.println(str);
    }
}
