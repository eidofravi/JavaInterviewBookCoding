package com.leetcode.array.twodimarray;

public class RemoveAdjacentDuplicatesString3 {

    public static void main(String[] args) {
        String str = "deeedbbcccbdaa";
        int k = 3;
        String s = new RemoveAdjacentDuplicatesString3().removeDuplicates(str, k);
        System.out.println(s);
    }



    public String removeDuplicates(String s, int k) {

        if (s.length() < k) {
            return s;
        }
        boolean digitRemoved = true;
        int counter = 1;

        while(digitRemoved) {
            boolean tempDigitRemoved = false;
            for (int i = 1 ; i < s.length(); i++) {
                Character ch1 = s.charAt(i - 1);
                Character ch2 = s.charAt(i);

                if (ch2 != ch1) {
                    counter = 1;
                    continue;
                }
                counter++;
                if (counter == k) {
                    int removeFirstIndex = i - k + 1;
                    StringBuilder sb = new StringBuilder();
                    sb.append(s.substring(0, removeFirstIndex));
                    sb.append(s.substring(i + 1));
                    s = sb.toString();
                    tempDigitRemoved = true;
                    break;
                }
            }
            counter = 1;
            digitRemoved = tempDigitRemoved;
        }
        return s;
    }
}
