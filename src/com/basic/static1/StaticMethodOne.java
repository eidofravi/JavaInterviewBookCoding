package com.basic.static1;

public class StaticMethodOne {
    public static String mysaticvar = "hello";
    public String mynonsaticvar = "helloworld";

    public static void main(String[] args) {
        staticMethod();
        System.out.println(mysaticvar);
       // System.out.println(mynonsaticvar);
       // nonSaticMethod();
    }

    public static void staticMethod() {
    }

    public void nonSaticMethod() {
    }
}
