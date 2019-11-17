package com.coding.String;

import java.util.HashMap;
import java.util.Map;

public class RemoveTextFromStringThird {
    public static void main(String[] args) {
        System.out.println(removeCharFromText("this is a not as a tricky as you thinkas", "as"));
        System.out.println(removeCharFromText(null, "as"));
        System.out.println(removeCharFromText("as", "as"));
    }

    public static String removeCharFromText(String text, String removeStr) {
        if (text == null) return null;
        char[] textArr = text.toCharArray();
        char[] removeStrAray = removeStr.toCharArray();
        StringBuilder tempSb = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        int rmIndex = 0;
        for (int index = 0; index < textArr.length; index++) {
            if (textArr[index] == removeStrAray[rmIndex]) {
                tempSb.append(textArr[index]);
                if (removeStr.equals(tempSb.toString())) {
                    tempSb = new StringBuilder();
                    continue;
                }
                rmIndex++;
                continue;
            }
            if (tempSb.toString().length() > 0) {
                sb.append(tempSb);
                tempSb = new StringBuilder();
            }
            rmIndex = 0;
            sb.append(textArr[index]);
        }
        return sb.toString();
    }
}
