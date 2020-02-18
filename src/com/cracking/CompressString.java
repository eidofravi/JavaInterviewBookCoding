package com.cracking;

import java.util.LinkedList;
import java.util.Queue;

public class CompressString {

    public static void main(String[] args) {
        String org = "abbbcccaadd";
        char[] a = org.toCharArray();
        int i = 0;
        int j = 1;
        int count = 0;
        StringBuilder sb = new StringBuilder();

        while (i < a.length) {
            if (i == a.length - 1 || a[i] != a[j]) {
                count++;
                sb.append(a[i]);
                sb.append(count);
                count = 0;
            } else {
                count++;
            }
            i++;
            j++;
        }
        System.out.println(sb.toString());
    }
}
