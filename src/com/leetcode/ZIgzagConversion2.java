package com.leetcode;

public class ZIgzagConversion2 {
    public static void main(String[] args) {
         //String str = new ZIgzagConversion2().convert("PAYPALISHIRING", 4);
        //String str = new ZIgzagConversion2().convert("PAYPAL", 4);  //PALYAP
        //String str = new ZIgzagConversion2().convert("PAYPALISHIRING", 3);
        //String str = new ZIgzagConversion2().convert("AB", 3);
        String str = new ZIgzagConversion2().convert("ABC", 2);
        System.out.println(str);
    }

    private String convert(String s, int numRows) {
        int[] indexArr = new int[s.length()];
        StringBuilder sb = new StringBuilder();
        int counter = 0;
        int index = 0;

        if (numRows < 2 || s.length() == 1 || s.length() <=  numRows) {
            return s;
        }

        while (counter < s.length()) {
            if (index != 0) {
                indexArr[index++] = counter;
            }
            indexArr[index++] = counter;
            int down = numRows;
            int diagonal = down - 2;
            counter = counter + down + diagonal;
        }

        if (counter >= s.length() && index < s.length()) {
            indexArr[index++] = counter;
        }


        while (indexArr[0] < numRows) {
            Character ch1 = s.charAt(indexArr[0]);
            sb.append(ch1);
            for (int i = 1; i < index ; i++) {
                if (indexArr[i - 1] != indexArr[i]) {
                    if (indexArr[i] < s.length()) {
                        Character ch = s.charAt(indexArr[i]);
                        sb.append(ch);
                    }
                }
            }
            for (int i = 0; i < index ; i++) {
                if (i % 2 == 0) {
                    indexArr[i] = ++indexArr[i];
                } else {
                    indexArr[i] = --indexArr[i];
                }
            }
        }
        return sb.toString();
    }
}








