package com.test;

public class DeepCopyConstructor {
    public static void main(String[] args) throws Exception {
        StudentDeepCopy student = new StudentDeepCopy("ravi");
        SchoolDeepCopy orgObj = new SchoolDeepCopy("ssvm", student);
        SchoolDeepCopy copyObj = new SchoolDeepCopy(orgObj);

        System.out.println("hashcode for original School object : " + orgObj.hashCode());
        System.out.println("hashcode for copied School object : " + copyObj.hashCode());

        System.out.println("hashcode for original StudentDeepCopy object : "
                + orgObj.getStudent().hashCode());
        System.out.println("hashcode for copied StudentDeepCopy object : "
                + copyObj.getStudent().hashCode());

        copyObj.getStudent().setName("toni");
        System.out.println("Original object field value changed from ravi to "
                + orgObj.getStudent().getName());
    }
}

class SchoolDeepCopy {
    private String schoolName;
    private StudentDeepCopy student;

    public SchoolDeepCopy(String schoolName, StudentDeepCopy student) {
        this.schoolName = schoolName;
        this.student = student;
    }

    public SchoolDeepCopy(SchoolDeepCopy orgObj) {
        this(orgObj.getSchoolName(), new StudentDeepCopy(orgObj.getStudent()));
    }
    public StudentDeepCopy getStudent() {
        return student;
    }
    public String getSchoolName() {
        return schoolName;
    }
    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class StudentDeepCopy {
    public StudentDeepCopy(StudentDeepCopy studentDeepCopy) {
        this(studentDeepCopy.getName());
    }
    public StudentDeepCopy(String name) {
        this.name = name;
    }

    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}