package com.leetcode;

public class LargestWordInDictByRemo {

    public static void main(String[] args) {
        //String[] dict = {"ale", "apple", "monkey", "plea"};
        String[] d = {"pintu", "geeksfor", "geeksgeeks", " forgeek"};
        // String orgStr = "abpcplea";
        String orgStr = "geeksforgeeks";
        String strWithmaxSize = "";

        for (String strInArr : d) {
            boolean isPresent = isPresentInStr(strInArr, orgStr);
            if (isPresent) {
                if (strInArr.length() > strWithmaxSize.length()) {
                    strWithmaxSize = strInArr;
                } else if (strInArr.length() == strWithmaxSize.length()) {
                    if (strInArr.compareTo(strWithmaxSize) < 0) {
                        strWithmaxSize = strInArr;
                    }
                }
            }
        }
        System.out.println(strWithmaxSize);
    }

    private static boolean isPresentInStr(String strInArr, String orgStr) {
        char[] charr = strInArr.toCharArray();
        for (int i = 0; i < charr.length; i++) {
            int index = orgStr.indexOf(charr[i]);
            if (index < 0) {
                return false;
            }
            if (index < orgStr.length()) {
                orgStr = orgStr.substring(index + 1);
            }
        }
        return true;
    }
}
