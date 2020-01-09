package com.basic;

import java.util.ArrayList;
import java.util.List;

public class UserFinalize {

    public static void main(String[] args) throws InterruptedException {
        UserFinalize obj = new UserFinalize();
        obj.myTestMethod();
        System.gc();
        Thread.sleep(10000);
        System.out.println("after gc is called");
    }

    private void myTestMethod() {
        List lst = new ArrayList();
        lst.add(1L);
    }

    @Override
    public void finalize() {
        System.out.println("finalize is called");
    }
}
