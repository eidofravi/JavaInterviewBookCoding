package com.leetcode.array;

import java.util.*;

public class Rankteamsbyvotes {

    public static void main(String[] args) {
        //  String arr[] = {"ABC", "ACB", "ABC", "ACB", "ACB"};
        String arr[] = {"WXYZ", "XYZW"};
      /*  String arr[] = {"FVSHJIEMNGYPTQOURLWCZKAX", "AITFQORCEHPVJMXGKSLNZWUY", "OTERVXFZUMHNIYSCQAWGPKJL", "VMSERIJYLZNWCPQTOKFUHAXG",
                "VNHOZWKQCEFYPSGLAMXJIUTR", "ANPHQIJMXCWOSKTYGULFVERZ", "RFYUXJEWCKQOMGATHZVILNSP", "SCPYUMQJTVEXKRNLIOWGHAFZ",
                "VIKTSJCEYQGLOMPZWAHFXURN", "SVJICLXKHQZTFWNPYRGMEUAO", "JRCTHYKIGSXPOZLUQAVNEWFM", "NGMSWJITREHFZVQCUKXYAPOL",
                "WUXJOQKGNSYLHEZAFIPMRCVT", "PKYQIOLXFCRGHZNAMJVUTWES", "FERSGNMJVZXWAYLIKCPUQHTO", "HPLRIUQMTSGYJVAXWNOCZEKF",
                "JUVWPTEGCOFYSKXNRMHQALIZ", "MWPIAZCNSLEYRTHFKQXUOVGJ", "EZXLUNFVCMORSIWKTYHJAQPG", "HRQNLTKJFIEGMCSXAZPYOVUW",
                "LOHXVYGWRIJMCPSQENUAKTZF", "XKUTWPRGHOAQFLVYMJSNEIZC", "WTCRQMVKPHOSLGAXZUEFYNJI"};*/

        //"VWFHSJARNPEMOXLTUKICZGYQ" // "RJSVHICQMTEXWPYKNOLFGUZA"
        String data = new Rankteamsbyvotes().rankTeams(arr);
        System.out.println(data);
    }

    public String rankTeams(String[] votes) {
        int totalRanks = votes[0].length();
        List<Character> allCandidates = strToList(votes[0]);

        /* Build rank matrix - ranking[i][j] is the number of votes for team j to be the i-th rank */
        int[][] ranking = new int[totalRanks][26];
        for (String v : votes) {
            for (int i = 0; i < v.length(); i++) {
                ranking[i][v.charAt(i) - 'A']++;
            }
        }
        /* Sort team list using the ranking matrix based on tie-breaking rule */
        allCandidates.sort(new Comparator<Character>() {
            @Override
            public int compare(Character c1, Character c2) {
                for (int i = 0; i < totalRanks; i++) {
                    if (ranking[i][c1 - 'A'] != ranking[i][c2 - 'A']) {
                        return ranking[i][c2 - 'A'] - ranking[i][c1 - 'A'];
                    }
                }
                return c1 - c2;
            }});
        return listToString(allCandidates);
    }

    private String listToString(List<Character> candidates) {
        StringBuilder sb = new StringBuilder();
        for (Character ch : candidates) {
            sb.append(ch);
        }
        return sb.toString();
    }


    private List<Character> strToList(String str) {
        List<Character> list = new ArrayList<>();
        for(char ch : str.toCharArray()) {
            list.add(ch);
        }
        return list;
    }
}
