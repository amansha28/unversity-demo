package com.example.universitydemo.model;

import java.io.Serializable;
import java.util.Set;

public class ProfessorCoursesResult implements Serializable {

    private String name;
    private Set<String> courses;

    public ProfessorCoursesResult() {
    }

    public ProfessorCoursesResult(String name, Set<String> courses) {
        this.name = name;
        this.courses = courses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getCourses() {
        return courses;
    }

    public void setCourses(Set<String> courses) {
        this.courses = courses;
    }
}
