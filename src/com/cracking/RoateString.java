package com.cracking;

import java.util.LinkedList;
import java.util.Queue;

public class RoateString {

    public static void main(String[] args) {
        String org = "abcdef";
        char[] orgchar = org.toCharArray();

        String rotatedString = "edabcf";
        Queue<Character> strng = new LinkedList<>();
        for (char ch : orgchar) {
            strng.add(ch);
        }

        for (int i = 0; i < orgchar.length; i++) {
            if (strng.size() > 0) {
                char lastChar = ((LinkedList<Character>) strng).pollLast();
                ((LinkedList<Character>) strng).push(lastChar);
                if (isEqual(strng, rotatedString)) {
                    System.out.println("string rotated");
                    break;
                }
            }
        }
    }

    public static boolean isEqual(Queue<Character> queueString, String rotatedString) {
        for (int index = 0; index < rotatedString.length(); index++) {
            char orgChar = ((Character) ((LinkedList) queueString).get(index)).charValue();
            if (!(orgChar == rotatedString.charAt(index))) {
                return false;
            }
        }
        return true;
    }


}
