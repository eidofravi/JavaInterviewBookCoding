package com.leetcode.string;

public class LongestRepeatingSubstring {

    public static void main(String[] args) {
        String str = "aabcaabdaab";
        int max = new LongestRepeatingSubstring().longestRepeatingSubstring(str);
        System.out.println(max);
    }

    public int longestRepeatingSubstring(String S) {
        int max = 0;
        int firstIndex = 0;
        int lastIndex = 0;
        while (lastIndex < S.length()) {
            String strLeft = S.substring(firstIndex + 1);
            String strSearch = S.substring(firstIndex, lastIndex + 1);
            if (strLeft.length() >= strSearch.length()) {
                if (strLeft.contains(strSearch)) {
                    max = Math.max(max, strSearch.length());
                    lastIndex++;
                } else {
                    firstIndex++;
                }
            } else {
                break;
            }
        }
        return max;
    }
}
