package com.cracking;

public class StringEdited {
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "bb";
        boolean value = false;
        if (str1.length() > str2.length()) {
           value = isOnePlaceEdited(str2, str1, str2.length());
        }  else if (str1.length() < str2.length()) {
            value = isOnePlaceEdited(str1, str2, str1.length());
        } else {
            value = isOnePlaceEdited(str1, str2, str1.length() - 1);
        }
        System.out.println(value);
    }
    public static boolean isOnePlaceEdited(String str1, String str2, int len) {
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        int count = 0;
        for (int i =0 ; i < arr1.length; i ++) {
            if (arr1[i] == arr2[i] ||
                    (i>1 && arr1[i] == arr2[i-1]) ||
                    (i < str2.length() && arr1[i] == arr2[i+1])) {
                count++;
            }
        }
        if (count == len) {
            return true;
        }
        return false;

    }
}
