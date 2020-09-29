package com.leetcode.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Rankteamsbyvotes3 {

    public static void main(String[] args) {
       // String arr[] = {"ABC","ACB","ABC","ACB","ACB"};
        String arr[] = {"FVSHJIEMNGYPTQOURLWCZKAX", "AITFQORCEHPVJMXGKSLNZWUY", "OTERVXFZUMHNIYSCQAWGPKJL", "VMSERIJYLZNWCPQTOKFUHAXG",
                "VNHOZWKQCEFYPSGLAMXJIUTR", "ANPHQIJMXCWOSKTYGULFVERZ", "RFYUXJEWCKQOMGATHZVILNSP", "SCPYUMQJTVEXKRNLIOWGHAFZ",
                "VIKTSJCEYQGLOMPZWAHFXURN", "SVJICLXKHQZTFWNPYRGMEUAO", "JRCTHYKIGSXPOZLUQAVNEWFM", "NGMSWJITREHFZVQCUKXYAPOL",
                "WUXJOQKGNSYLHEZAFIPMRCVT", "PKYQIOLXFCRGHZNAMJVUTWES", "FERSGNMJVZXWAYLIKCPUQHTO", "HPLRIUQMTSGYJVAXWNOCZEKF",
                "JUVWPTEGCOFYSKXNRMHQALIZ", "MWPIAZCNSLEYRTHFKQXUOVGJ", "EZXLUNFVCMORSIWKTYHJAQPG", "HRQNLTKJFIEGMCSXAZPYOVUW",
                "LOHXVYGWRIJMCPSQENUAKTZF", "XKUTWPRGHOAQFLVYMJSNEIZC", "WTCRQMVKPHOSLGAXZUEFYNJI"};
       // new Rankteamsbyvotes3().rankTeams(arr);
        String data = new Rankteamsbyvotes3().rankTeams(arr);
        System.out.println(data);

    }

    public String rankTeams(String[] votes) {
        int n= votes[0].length();
        HashMap<Character, int[]> map= new HashMap<>();
        for(String str: votes){
            for(int i=0; i<n; i++){
                char ch = str.charAt(i);
                //Initialising an array if the character is absent
                map.computeIfAbsent(ch, a-> new int[n]);
                map.get(ch)[i]++;
            }
        }
        //Sort using the comparator
        List<Character> res= new ArrayList<>(map.keySet());
        //We need to sort according to the positions
        Collections.sort(res, (a, b)->
        {
            for(int i=0; i<n; i++)
                if(map.get(b)[i]!= map.get(a)[i])
                    return map.get(b)[i]- map.get(a)[i];
            return 0;
        });

        //Convert it into a string and return
        StringBuilder sb= new StringBuilder();
        for(int i=0; i<res.size(); i++)
            sb.append(res.get(i));
        return sb.toString();
    }
}
