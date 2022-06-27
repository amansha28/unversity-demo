package com.example.springcruddemo.controller;

import com.example.springcruddemo.bean.Course;
import com.example.springcruddemo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {


    @Autowired
    CourseService courseService;

    @GetMapping("/courses")
    public List<Course> getAllCourses(){
        return courseService.getAllCourses();
    }

    @GetMapping("/courses/{id}")
    public Course getCoursesById(@PathVariable("id") int id){
        return courseService.getCourseById(id);
    }

    @PostMapping("/courses")
    public Course addCourse(@RequestBody Course course)
    {
        return courseService.addCourse(course);
    }

    @DeleteMapping("/courses/{id}")
    public String removeCoursesById(@PathVariable("id") int id){
        return courseService.removeCourseById(id);
    }
}
