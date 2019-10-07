package com.test;

import java.util.ArrayList;
import java.util.List;

public class StringLifecycle {
    private String test;

    public StringLifecycle(String test) {
        this.test = test;
    }
    public StringLifecycle() {
    }

    public static void main(String[] args) {
        new StringLifecycle().callMethodOne();
    }

    private void callMethodOne() {
        String str1 = "HelloEveryOne";
        String str2= "HelloEveryOne";
        String str3= new String(str2);
        List<StringLifecycle> lst = new ArrayList<>();
        lst.add(new StringLifecycle(str1));
        lst.add(new StringLifecycle(str2));
        lst.add(new StringLifecycle(str3));
        while(true) {}
    }

}
