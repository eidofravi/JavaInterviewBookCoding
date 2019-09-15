package com.test.one.usethis;

public class School {
    public static void main(String args[]) {
        Teacher teachObj = new Teacher();
        System.out.println("hashcode for teachObj : " + teachObj.hashCode());
        teachObj.callTeacher();
    }
}
class Teacher {
    public void callTeacher() {
        Student std = new Student();
        // hash code value at below line matches with that of value at line no 6
        // it represents the same teacher object
        System.out.println("hashcode for this : " + this.hashCode());
        std.passTeacherInstance(this);
    }
    public void teach() {
        System.out.println("teacher teaches economics");
    }
}

class Student {
    public void passTeacherInstance(Teacher teacher) {
      teacher.teach();
    }
}
