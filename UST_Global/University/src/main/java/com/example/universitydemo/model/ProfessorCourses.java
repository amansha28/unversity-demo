package com.example.universitydemo.model;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

//@Component
public interface ProfessorCourses {

    public String getName();
    public Set<String> getCourses();

}
