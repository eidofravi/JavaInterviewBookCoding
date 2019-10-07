package com.test;

public class StringInSwitch {

    public static void main(String[] args) {
        String str = "Sunday";
        switch (str) {
            case "Monday" : {
                System.out.println("Its Monday today");
                break;
            }
            case "Sunday" : {
                System.out.println("Its Sunday today");
                break;
            }
            default: {
                System.out.println("I am default");
            }


        }
    }
}
