package com.coding.String;

import java.util.HashMap;
import java.util.Map;

public class RemoveTextFromString {
    public static void main(String[] args) {
        System.out.println(removeCharFromText("this is a not as a tricky as you think", "as"));
    }

    public static String removeCharFromText(String text, String removeStr) {
        if (text == null) return null;
        char[] textArr = text.toCharArray();
        char[] removeStrAray = removeStr.toCharArray();
        char firstRemoveChar = removeStrAray[0];

        StringBuilder sb = new StringBuilder();
        int tempIndex = 0;
        Map<Integer, Boolean> indexMap  = new HashMap<>();
        for (int index = 0; index < textArr.length; index++) {
            if (textArr[index] == firstRemoveChar) {
                tempIndex = index + 1;
                for (int rIndex = 1 ; rIndex < removeStrAray.length; rIndex++) {
                    if (textArr[tempIndex] == removeStrAray[rIndex]) {
                        indexMap.put(index, true);
                        indexMap.put(tempIndex, true);
                        tempIndex++;
                    } else {
                        indexMap = new HashMap<>();
                        break;
                    }
                }
            }
            if (null != indexMap.get(index) && indexMap.get(index)) {
                continue;
            }
            sb.append(textArr[index]);
        }
        return sb.toString();
    }
}
