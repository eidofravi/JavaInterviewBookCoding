package com.leetcode.string;

public class BullsAndCows {

    public static void main(String[] args) {
        new BullsAndCows().getHint("18077",                "38103");
    }

    public String getHint(String secret, String guess) {
        String s = secret;
        String g = guess;
        if (s.length() != g.length()) return "";
        int cows = 0, bulls = 0;
        int[] counter = new int[10];
        for (int i = 0; i < s.length(); i++) {
            int a = s.charAt(i) - '0';
            int b = g.charAt(i) - '0';
            if (a == b) {
                bulls++;
            } else {
                if (counter[a]++ < 0) {
                    cows++;
                }
                if (counter[b]-- > 0) {
                    cows++;
                }
            }
        }
        return bulls + "A" + cows + "B";

    }
}
