package com.example.universitydemo.model;

import java.util.Set;

/*
* This is DTO class to map native Query results.
* */
public interface ProfessorCourses {

    public String getName();

    public Set<String> getCourses();

}
