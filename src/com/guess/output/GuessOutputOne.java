package com.guess.output;

public class GuessOutputOne extends GuessOutputOneParent{
    public static void main(String args[]){
        System.out.println(new GuessOutputOne().toString());
    }
    /*public void myParentClassMethod(){

    }*/
}

class GuessOutputOneParent {
    public static void myParentClassMethod() {
        System.out.println("method of parent class");
    }
}
