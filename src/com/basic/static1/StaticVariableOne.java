package com.basic.static1;

public class StaticVariableOne {
    public static String var = "world";

    public static void main(String[] args) {
        StaticVariableOne obj1 = new StaticVariableOne();
        StaticVariableOne obj2 = new StaticVariableOne();
        obj1.changeValue();
        System.out.println("Obj2 count  = "+obj2.var);
    }

    private void changeValue() {
        var = "helloworld";
    }

}
