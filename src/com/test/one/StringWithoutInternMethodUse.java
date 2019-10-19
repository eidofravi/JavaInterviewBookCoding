package com.test.one;

public class StringWithoutInternMethodUse {
    String text;

    public StringWithoutInternMethodUse(String text) {
        this.text = text;
    }

    public static void main(String[] args) {
        String str1 = "HelloEveryone";
        String str2 = new String("HelloEveryone");
        StringWithoutInternMethodUse obj1 = new StringWithoutInternMethodUse(str1);
        StringWithoutInternMethodUse obj2 = new StringWithoutInternMethodUse(str2);
        while(true){
        }
    }
}
