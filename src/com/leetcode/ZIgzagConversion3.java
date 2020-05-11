package com.leetcode;

public class ZIgzagConversion3 {
    public static void main(String[] args) {
       // String str = new ZIgzagConversion2().convert("PAHNAPLSIIGYIR", 4);
        String str = new ZIgzagConversion3().convert("PAYPALISHIRING", 4);
        System.out.println(str);
    }

    private String convert(String s, int numRows) {
        int[] indexArr = new int[s.length()];
        StringBuilder sb = new StringBuilder();
        indexArr[0] = 0;
        indexArr[1] = 6;
        indexArr[2] = 6;
        indexArr[3] = 12;
        indexArr[4] = 12;

        while (indexArr[0] < numRows) {
            Character ch1 = s.charAt(indexArr[0]);
            sb.append(ch1);

            if (indexArr[0] != indexArr[1]) {
                Character ch2 = s.charAt(indexArr[1]);
                sb.append(ch2);
            }

            if (indexArr[1] != indexArr[2]) {
                Character ch3 = s.charAt(indexArr[2]);
                sb.append(ch3);
            }

            if (indexArr[2] != indexArr[3]) {
                Character ch4 = s.charAt(indexArr[3]);
                sb.append(ch4);
            }

            if (indexArr[3] != indexArr[4]) {
                if (indexArr[4] < s.length()) {
                    Character ch5 = s.charAt(indexArr[4]);
                    sb.append(ch5);
                }
            }

            indexArr[0] = ++indexArr[0];
            indexArr[1] = --indexArr[1];
            indexArr[2] = ++indexArr[2];
            indexArr[3] = --indexArr[3];
            indexArr[4] = ++indexArr[4];
        }

        return sb.toString();
    }
}








