package com.example.springcruddemo.bean;

public class Course {

    private int id;
    private String name;
    private int department_id;
    private int credits;

    public Course() {
    }

    public Course(int id, String name, int department_id, int credits) {
        this.id = id;
        this.name = name;
        this.department_id = department_id;
        this.credits = credits;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department_id=" + department_id +
                ", credits=" + credits +
                '}';
    }
}
