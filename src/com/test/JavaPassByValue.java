package com.test;
public class JavaPassByValue {
    public static void main(String[] args) {
        Employee emp1 = new Employee("ravi", "khandelwal");
        int localVariable = 10;
        System.out.println("initial value for localVariable = " + localVariable);
        System.out.println("initial value for employee first name = " + emp1.getFirstName());

        changeValues(localVariable, emp1);

        System.out.println("changed value for localVariable = " + localVariable);
        System.out.println("changed value for employee first name = " + emp1.getFirstName());
    }
    static void changeValues(int copiedLocalVairable, Employee emp2) {
        copiedLocalVairable = 20;
        emp2.setFirstName("toni");
        emp2 = new Employee("vaanya", "khandelwal");
        System.out.println("value for changed copiedLocalVairable = " + copiedLocalVairable);
        System.out.println("value for changed employee first name = " + emp2.getFirstName());
    }
}

class Employee {
    private String firstName;
    private String lastName;
    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
