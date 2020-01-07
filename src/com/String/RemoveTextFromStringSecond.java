package com.String;

import java.util.HashMap;
import java.util.Map;

public class RemoveTextFromStringSecond {
    public static void main(String[] args) {
        System.out.println(removeCharFromText("this is a not as a tricky as you thinkas", "as"));
        System.out.println(removeCharFromText(null, "as"));
        System.out.println(removeCharFromText("as", "as"));
    }

    public static String removeCharFromText(String text, String removeStr) {
        if (text == null) return null;
        int lastIndex = removeStr.length();
        int startIndex = 0;
        StringBuilder sb = new StringBuilder();
        while (startIndex < text.length()) {
            String part = text.substring(startIndex, lastIndex);
            if (!part.equals(removeStr)) {
                sb.append(part);
            }
            startIndex = lastIndex;
            lastIndex = lastIndex + removeStr.length();
        }
        return sb.toString();
    }
}
