package com.test;

import com.domain.Student;

public class ClassLoadingTest {
    public static void main(String[] args) throws Exception {
      // Application class loader loads the ClassLoadingTest class file, Output -> sun.misc.Launcher$AppClassLoader@18b4aac2
      System.out.println(ClassLoadingTest.class.getClassLoader());

      // Extension class loader is Parent of Application Class loader Output -> sun.misc.Launcher$ExtClassLoader@1540e19d
      System.out.println(ClassLoadingTest.class.getClassLoader().getParent());

      //BootStrap class loader is Parent of Extension class loader but Output will be shown as null
        // because there is no implementation of BootStrap class loader in java. This is written in native language C
      System.out.println(ClassLoadingTest.class.getClassLoader().getParent().getParent());

      System.out.println(Student.class.getClassLoader().loadClass("com.domain.Student"));
    }
}
