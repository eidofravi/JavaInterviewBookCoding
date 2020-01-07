package com.String;

public class RemoveCharacterFromString {
    public static void main(String[] args) {
        System.out.println(removeCharFromText("helloworld", 'l'));
        System.out.println(removeCharFromText("abcd", 'l'));
        System.out.println(removeCharFromText(null, 'l'));
    }

    public static String removeCharFromText(String text, char removeChar) {
        if (text == null) return null;
        if (text.indexOf(removeChar) == -1) {
            return text;
        }
        char[] textArr = text.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int index = 0; index < textArr.length; index++) {
            if (textArr[index] != removeChar) {
                sb.append(textArr[index]);
            }
        }
        return sb.toString();
    }
}
