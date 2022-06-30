package com.example.universitydemo.controller;

import com.example.universitydemo.dao.CourseDao;
import com.example.universitydemo.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseDao courseDao;

    @GetMapping("/courses")
    public List<Course> getAllCourses(){
        return courseDao.findAll();
    }
}
