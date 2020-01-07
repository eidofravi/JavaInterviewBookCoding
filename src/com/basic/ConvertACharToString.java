package com.basic;

public class ConvertACharToString {
    public static void main(String[] args) {
        char ch = 'a';
        char charArr[] = new char[1];
        charArr[0] = ch;
        String convertedStr = Character.toString(ch);
        String convertedStr2 = String.valueOf(ch);
        String convertedStr3 = new String(charArr);
        System.out.println(convertedStr3);
    }
}
