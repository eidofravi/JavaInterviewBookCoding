package com.test;

public class CallConstructorWithin {
    CallConstructorWithin() {
        this("calling constructor");
    }
    CallConstructorWithin(String name) {
        System.out.println("name = [" + name + "]");
    }
    public static void main(String[] args) {
        new CallConstructorWithin();
    }
}

