package com.leetcode;

public class EncodeString {
    public static void main(String[] args) {
        System.out.println(new EncodeString().encodeString("AAABBCDDED"));
        System.out.println(new EncodeString().encodeString("AAABBCDDEDD"));
        System.out.println(new EncodeString().encodeString("A"));
        System.out.println(new EncodeString().encodeString(""));
    }

    private String encodeString(String str) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        int nIndex = 1;
        int count = 0;
        while(index < str.length()) {
            if (index == str.length() - 1 || str.charAt(index) != str.charAt(nIndex)) {
                sb.append(str.charAt(index));
                sb.append(++count);
                count = 0;
            } else {
                count++;
            }
            index++;
            nIndex++;
        }
        return sb.toString();
    }
}
