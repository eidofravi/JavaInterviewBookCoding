package com.leetcode;

public class ZIgzagConversion {
    public static void main(String[] args) {
        //String str = new ZIgzagConversion().convert("PAHNAPLSIIGYIR", 4);
        String str = new ZIgzagConversion().convert("AB", 1);
        System.out.println(str);
    }

    private String convert(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }
        Character[][] arr = new Character[numRows][numRows * 2];

        int rindex = 0;
        int cindex = 0;
        boolean diagonal = false;
        boolean down = false;

        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            arr[rindex][cindex] = ch;

            if (rindex == 0) {
                diagonal = false;
                down = true;
            }
            if (rindex == numRows - 1) {
                diagonal = true;
                down = false;
            }
            if (diagonal) {
                rindex--;
                cindex++;
            }
            if (down) {
                rindex++;
            }

        }


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numRows * 2; j++) {
                if (null != arr[i][j])
                    sb.append(arr[i][j]);
            }
        }
        return sb.toString();
    }
}








    /*Character[][] arr = new Character[4][8];
    String str = "PAYPALISHIRING";
    int rindex = 0;
    int cindex = 0;
    int rows = 4;
    boolean diagonal = false;
    boolean down = false;

        for (int i = 0; i < str.length(); i++) {
        Character ch = str.charAt(i);
        arr[rindex][cindex] = ch;

        if (rindex == 0) {
        diagonal = false;
        down = true;
        }
        if (rindex == 3) {
        diagonal = true;
        down = false;
        }
        if (diagonal) {
        rindex--;
        cindex++;
        }
        if (down) {
        rindex++;
        }

        }

        System.out.println(arr);
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < rows ; i++) {
        for (int j = 0 ; j < 8 ; j++) {
        if (null != arr[i][j])
        sb.append(arr[i][j]);
        }
        }
        System.out.println(sb.toString());*/
