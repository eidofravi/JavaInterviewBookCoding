package com.basic;

public class CharArr {
    public static void main(String[] args) {
      /*  String str = "aAzZ";
        char[] arr = str.toCharArray();
        for (char chara : arr) {
            System.out.println(chara);
            System.out.println((int)chara);
        }

       for (int i = 0; i<300; i++) {
           char ch = (char)i;
           System.out.println(i);
           System.out.println(ch);
       }*/

       String str = "1234";
       double strlen = str.length() - 1;
       int sum = 0;
       for (int i =0; i < str.length(); i++) {
           char ch = str.charAt(i);
           int val = ch - '0';
           int powval = (int)Math.pow((double)10, strlen--);
           sum = sum + val * powval;
       }
        System.out.println(sum);

    }
}
