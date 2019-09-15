package com.test.one;

public class ThisForConstructor {

    public static void main(String[] args) {
        new TestConstructorCalling();
    }
}
class TestConstructorCalling {
    public TestConstructorCalling() {
        this("default constructor is calling");
    }

    private TestConstructorCalling(String arg) {
        System.out.println(arg);
    }
}
