package com.leetcode;

public class ZIgzagConversion5 {
    public static void main(String[] args) {
        String str = new ZIgzagConversion5().convert("PAYPALISHIRING", 4);
        //String str = new ZIgzagConversion2().convert("PAYPAL", 4);  //PALYAP
        //String str = new ZIgzagConversion2().convert("PAYPALISHIRING", 3);
        //String str = new ZIgzagConversion2().convert("AB", 3);
        //String str = new ZIgzagConversion5().convert("ABC", 2);
        System.out.println(str);
    }

    private String convert(String s, int numRows) {
        StringBuilder sb = new StringBuilder();
        if (numRows < 2 || s.length() == 1 || s.length() <= numRows) {
            return s;
        }
        int rowcount = 0;
        int len1 = 0;
        int down = numRows;
        int diagonal = down - 2;
        int move = down + diagonal;
        int diff = 0;
        while (rowcount < numRows) {
            int len = len1++;
            boolean skipFirst = false;
            while (len < s.length() || len - diff < s.length()) {
                if (skipFirst && diff !=0 && move != diff) {
                    int prevInex = len - diff;
                    if (prevInex < s.length()) {
                        Character ch2 = s.charAt(prevInex);
                        sb.append(ch2);
                    }

                }
                skipFirst = true;
                if (len < s.length()) {
                    Character ch3 = s.charAt(len);
                    sb.append(ch3);
                }
                len = len + move;
            }
            diff = diff + 2;
            rowcount++;
        }
        return sb.toString();
    }
}








