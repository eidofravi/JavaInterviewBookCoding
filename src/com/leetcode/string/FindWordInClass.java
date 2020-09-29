package com.leetcode.string;

import java.util.Arrays;
import java.util.List;

public class FindWordInClass {
    public static void main(String[] args) {

       // System.out.println(new FindWordInClass().wordBreak("leetcode", Arrays.asList("leet", "code")));
        System.out.println(new FindWordInClass().wordBreak("aaaaaaa", Arrays.asList("aaaa", "aaa")));
    }

    public boolean wordBreak(String s, List<String> wordDict) {

        int sInd = 0;
        int nInd = 1;

        while (nInd <= s.length()) {
            String substr = s.substring(sInd, nInd);

            if (wordDict.contains(substr)) {
                s = s.substring(substr.length());
                nInd = 1 ;
                continue;
            }
            nInd++;
        }

        return s.length() == 0;

    }
}
