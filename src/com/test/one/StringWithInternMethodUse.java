package com.test.one;

public class StringWithInternMethodUse {
    String text;

    public StringWithInternMethodUse(String text) {
        this.text = text;
    }

    public static void main(String[] args) {
        String str1 = "HelloEveryone";
        String str2 = new String("HelloEveryone").intern();
        StringWithInternMethodUse obj1 = new StringWithInternMethodUse(str1);
        StringWithInternMethodUse obj2 = new StringWithInternMethodUse(str2);
        while(true){
        }
    }
}
