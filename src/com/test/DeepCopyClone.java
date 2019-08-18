package com.test;
public class DeepCopyClone {
    public static void main(String[] args) throws Exception {
        StudentDeepCopyByClone student = new StudentDeepCopyByClone("ravi");
        SchoolDeepCopyByClone orgObj = new
                SchoolDeepCopyByClone("ssvm", student);
        SchoolDeepCopyByClone copyObj = (SchoolDeepCopyByClone)orgObj.clone();

        System.out.println("hashcode for original School object : " + orgObj.hashCode());
        System.out.println("hashcode for copied School object : " + copyObj.hashCode());

        System.out.println("hashcode for original StudentDeepCopyByClone object : "
                + orgObj.getStudent().hashCode());
        System.out.println("hashcode for copied StudentDeepCopyByClone object : "
                + copyObj.getStudent().hashCode());

        copyObj.getStudent().setName("toni");
        System.out.println("Original object field value changed from ravi to "
                + orgObj.getStudent().getName());
    }
}
class SchoolDeepCopyByClone implements Cloneable {
    private String schoolName;
    private StudentDeepCopyByClone student;

    public SchoolDeepCopyByClone(String schoolName, StudentDeepCopyByClone student) {
        this.schoolName = schoolName;
        this.student = student;
    }
    public StudentDeepCopyByClone getStudent() {
        return student;
    }
    public void setStudent(StudentDeepCopyByClone student) {
        this.student = student;
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        SchoolDeepCopyByClone clonedObj = (SchoolDeepCopyByClone)super.clone();
        clonedObj.setStudent((StudentDeepCopyByClone)clonedObj.getStudent().clone());
        return clonedObj;
    }
}

class StudentDeepCopyByClone implements Cloneable {
    public StudentDeepCopyByClone(String name) {
        this.name = name;
    }
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}