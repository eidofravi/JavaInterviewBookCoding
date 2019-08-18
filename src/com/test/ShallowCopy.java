package com.test;

public class ShallowCopy {
    public static void main(String[] args) throws Exception {
        Student student = new Student("ravi");
        School orgObj = new School("ssvm", student);
        School copyObj = (School)orgObj.clone();

        System.out.println("hashcode for original School object : " + orgObj.hashCode());
        System.out.println("hashcode for copied School object : " + copyObj.hashCode());

        System.out.println("hashcode for original Student object : " + orgObj.getStudent().hashCode());
        System.out.println("hashcode for copied Student object : " + copyObj.getStudent().hashCode());

        copyObj.getStudent().setName("toni");
        System.out.println("Original object field value changed from ravi to " + orgObj.getStudent().getName());
    }
}
class School implements Cloneable {
    private String schoolName;
    private Student student;

    public School(String schoolName, Student student) {
        this.schoolName = schoolName;
        this.student = student;
    }
     public Student getStudent() {
        return student;
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
class Student {
    private String name;
    public Student(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}