package com.test.one;

public class StaticKeyWordUse {
    static String test = "hello";
    String nonStaticTest = "hellononstatic";
    public static void main(String[] args) {
        System.out.println(test);
        StaticKeyWordUse obj1 = new StaticKeyWordUse();
        obj1.test = "world";

        StaticKeyWordUse obj2 = new StaticKeyWordUse();
        System.out.println(obj2.test);
        while(true) {}
    }
}
