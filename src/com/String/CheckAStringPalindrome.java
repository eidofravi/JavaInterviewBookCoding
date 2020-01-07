package com.String;

public class CheckAStringPalindrome {
    public static void main(String[] args) {
        System.out.println("null is Palindrome : " +  checkIfPalindrome(null));
        System.out.println("sdf43%%^ is Palindrome : " +  checkIfPalindrome("sdf43%%^"));
        System.out.println("a is Palindrome : " +  checkIfPalindrome("a"));
        System.out.println("ab is Palindrome : " +  checkIfPalindrome("ab"));
        System.out.println("aba is Palindrome : " +  checkIfPalindrome("aba"));
        System.out.println("ababa is Palindrome : " +  checkIfPalindrome("ababa"));
        System.out.println("abba is Palindrome : " +  checkIfPalindrome("abba"));
        System.out.println("abbab is Palindrome : " +  checkIfPalindrome("abbab"));
    }
    private static boolean checkIfPalindrome(String text) {
        if (null == text) return false;
        StringBuilder sb = new StringBuilder(text);
        String reverseText = sb.reverse().toString();
        return text.equals(reverseText);
    }

    private static boolean checkIfPalindrome2(String text) {
        if (null == text) return false;
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
}
