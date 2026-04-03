package org.example;

public class Student {
    private int id;
    private String name;
    private String dept;
    private int marks;

    public Student(String name, String dept, int marks) {
        this.name = name;
        this.dept = dept;
        this.marks = marks;
    }

    public Student(int id, String name, String dept, int marks) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.marks = marks;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getDept() { return dept; }
    public int getMarks() { return marks; }
}
