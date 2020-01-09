package com.basic.static1;

public class StaticOuterClass {
    public static void main(String args[]) {
        System.out.println(OuterClass.data);
        OuterClass.InnerClass obj = new OuterClass.InnerClass();
        obj.msg();
    }
}

class OuterClass {
    static int data = 30;

    static class InnerClass {
        void msg() {
            System.out.println("data is " + data);
        }
    }

}
