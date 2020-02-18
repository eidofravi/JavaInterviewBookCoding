package com.cracking;

public class FillNewStrInOrgString {
    public static void main(String[] args) {
        String str = " Hello my  kids        ";
        char[] strArr = str.toCharArray();
        int strlen = str.length();
        boolean endspace = false;
        int lastInd = strlen - 1;
        for (int i = strlen - 1; i >= 0; i--) {
            char ch = strArr[i];
            if (ch == ' ' && !endspace) {
                continue;
            }
            endspace = true;
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
