package com.test;

import java.util.ArrayList;
import java.util.List;

public class StringLifecycleMultipleThread {
    private String test;
    public StringLifecycleMultipleThread(String str4) {
        test = str4;
    }

    public StringLifecycleMultipleThread() {
    }

    public static void main(String[] args) {

        new StringLifecycleMultipleThread().callMethodOne();
        String str4= "HelloEveryOne111";
        List<StringLifecycleMultipleThread> lst = new ArrayList<>();

        lst.add(new StringLifecycleMultipleThread(str4));

        StringLifeCycleThread slft = new StringLifeCycleThread();
        Thread t1 = new Thread(slft);

        StringLifeCycleThread2 slct2 = new StringLifeCycleThread2();
        Thread t2 = new Thread(slct2);
        t1.start();
        t2.start();

        while(true) {}
    }

    private void callMethodOne() {
        String str1 = "HelloEveryOne";
        String str2= "HelloEveryOne";
    }
}

class StringLifeCycleThread implements Runnable {
    private String test;
    public StringLifeCycleThread(String test) {
        this.test = test;
    }
    public StringLifeCycleThread() {
    }

    @Override
    public void run() {
            callMethodOne();
            String str4 = "HelloEveryOne111";
            List<StringLifeCycleThread> lst = new ArrayList<>();
            lst.add(new StringLifeCycleThread(str4));

        while(true) {}
    }

    private void callMethodOne() {
        String str1 = "HelloEveryOne";
        String str2= "HelloEveryOne";
        String str3= "HelloEveryOne11";
        List<StringLifeCycleThread> lst = new ArrayList<>();
        lst.add(new StringLifeCycleThread(str1));
        lst.add(new StringLifeCycleThread(str2));
        lst.add(new StringLifeCycleThread(str3));
    }
}
class StringLifeCycleThread2 implements Runnable {
    private String test;
    public StringLifeCycleThread2(String test) {
        this.test = test;
    }
    public StringLifeCycleThread2() {
    }

    @Override
    public void run() {
        callMethodOne();
        String str4 = "HelloEveryOne111";
        List<StringLifeCycleThread2> lst = new ArrayList<>();
        lst.add(new StringLifeCycleThread2(str4));

        while(true) {}
    }

    private void callMethodOne() {
        String str1 = "HelloEveryOne";
        String str2= "HelloEveryOne";
        String str3= "HelloEveryOne11";
        List<StringLifeCycleThread2> lst = new ArrayList<>();
        lst.add(new StringLifeCycleThread2(str1));
        lst.add(new StringLifeCycleThread2(str2));
        lst.add(new StringLifeCycleThread2(str3));
    }
}