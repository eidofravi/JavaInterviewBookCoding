package com.guess.output;

public class GuessOutputTwo {
    public static void main(String args[]){
        GuessOutputTwo obj = null;
        System.out.println(obj.foo());
    }

    public static String foo(){
        System.out.println("Test foo called");
        return "";
    }
}
