package com.test.one;

public class School {
    public static void main(String args[]) {
        Student obj = new Student();
        obj.setFirstName("testName");
        obj.lastName = "testLastName";
        System.out.println("name : " +  obj.getFirstName());
        System.out.println("last name : " +  obj.getLastName());
    }
}

class Student {
    private String firstName;
    public String lastName;
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
