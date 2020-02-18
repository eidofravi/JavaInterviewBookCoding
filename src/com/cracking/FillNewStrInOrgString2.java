package com.cracking;

public class FillNewStrInOrgString2 {
    public static void main(String[] args) {
        String str = "    Hello    my kids                     ";
        char[] strArr = str.toCharArray();
        int strlen = str.length();
        boolean endspace = false;
        int blankSpaceCountBetweenChar = 0;
        int nonSpaceCharLen = 0;
        for (int i = strlen - 1; i >= 0; i--) {
            char ch = strArr[i];
            if (ch == ' ' && !endspace) {
                continue;
            }
            endspace = true;
            if (ch == ' ') {
                blankSpaceCountBetweenChar++;
            } else {
                nonSpaceCharLen++;
            }
        }
        strlen = nonSpaceCharLen + blankSpaceCountBetweenChar;
        int lastInd = nonSpaceCharLen + 3 * blankSpaceCountBetweenChar - 1;
        for (int i = strlen - 1; i > 0; i--) {
            char ch = strArr[i];
            if (ch != ' ') {
                strArr[lastInd--] = ch;
            } else {
                strArr[lastInd--] = '0';
                strArr[lastInd--] = '2';
                strArr[lastInd--] = '%';
            }
        }
        String newStr = new String(strArr);
        System.out.println(newStr);
    }
}
