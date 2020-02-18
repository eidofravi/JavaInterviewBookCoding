package com.basic.static1;

public class StaticOuterDesign {
    private String aField = "test";

    public static void main(String... args) {

        StaticExample x1 = new StaticExample();
        System.out.println(x1.getField());

        //does not compile:
        // NonStaticExample x2 = new NonStaticExample();

        StaticOuterDesign m1 = new StaticOuterDesign();
        NonStaticExample x2 = m1.new NonStaticExample();
        System.out.println(x2.getField());
    }

    private static class StaticExample {
        String getField() {
            //does not compile, static inner class can not access the member variable of outer class
            return "";
        }
    }

    private class NonStaticExample {
        String getField() {
            return aField;
        }
    }
}
