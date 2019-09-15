package com.test;

public class NoArgConstructor {
    public static void main(String[] args) {
        NoArgConstructor obj = new NoArgConstructor();
        obj.callingMemberMethod();

    }
    public void callingMemberMethod() {
        System.out.println("method called ");
    }
    public NoArgConstructor(String args) {

    }

}
