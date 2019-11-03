package com.coding.String;

public class CheckAStringPalindrome {
    public static void main(String[] args) {
        System.out.println(checkIfPalindrome(null));
        System.out.println(checkIfPalindrome("sdf43%%^"));
        System.out.println(checkIfPalindrome("a"));
        System.out.println(checkIfPalindrome("ab"));
        System.out.println(checkIfPalindrome("aba"));
        System.out.println(checkIfPalindrome("ababa"));
        System.out.println(checkIfPalindrome("abba"));

    }

    private static boolean checkIfPalindrome(String text) {
        if (null == text) {
            return false;
        }
        StringBuilder sb = new StringBuilder(text);
        String reverseText = sb.reverse().toString();
        if (text.equals(reverseText)) {
            return true;
        }
        return false;
    }

    private static boolean checkIfPalindrome1(String text) {
        if (null == text) {
            return false;
        }
        char[] textArr  = text.toCharArray();
        int lIndex = textArr.length - 1;
        for (int sIndex =0 ; sIndex < textArr.length; sIndex++) {
            if (lIndex >  sIndex) {
                if (textArr[sIndex] != textArr[lIndex]) {
                    return false;
                }
                lIndex--;
            }
        }
        return true;
    }

    private static boolean checkIfPalindrome2(String text) {
        if (null == text) {
            return false;
        }
        char[] textArr  = text.toCharArray();
        int lIndex = textArr.length - 1;
        for (int sIndex =0 ; sIndex < textArr.length / 2; sIndex++) {
                if (textArr[sIndex] != textArr[lIndex]) {
                    return false;
                }
                lIndex--;
            }
        return true;
    }

    private static boolean checkIfPalindrome5(String text) {
        if (null == text) {
            return false;
        }
        char[] textArr  = text.toCharArray();
        int sIndex = 0;
        int lIndex = textArr.length - 1;
        while (true) {
            if (lIndex > sIndex) {
                if (textArr[sIndex] != textArr[lIndex]) {
                    return false;
                }
                lIndex--;
                sIndex++;
            } else {
                break;
            }
        }
        return true;
    }
}
