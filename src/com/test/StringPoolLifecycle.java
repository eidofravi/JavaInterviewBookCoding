package com.test;

import java.util.ArrayList;
import java.util.List;

public class StringPoolLifecycle {
    private String test;

    public StringPoolLifecycle(String test) {
        this.test = test;
    }
    public StringPoolLifecycle() {    }

    public static void main(String[] args) {
        new StringPoolLifecycle().callMethodOne();
        String str4= "HelloEveryOne111";
        List<StringLifecycle> lst = new ArrayList<>();
        lst.add(new StringLifecycle(str4));
        while(true) {}
    }

    private void callMethodOne() {
        String str1 = "HelloEveryOne";
        String str2= "HelloEveryOne";
        String str3= "HelloEveryOne11";
    }

}
