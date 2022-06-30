package com.example.universitydemo.controller;

import com.example.universitydemo.model.Course;
import com.example.universitydemo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseService courseService;

    @GetMapping("/courses")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }


    @PostMapping("/courses")
    public Course addCourse(@RequestBody Course course) {
        return courseService.addCourse(course);
    }

    @DeleteMapping("/courses/{id}")
    public void removeCourseById(@PathVariable("id") int courseId) {
        courseService.removeCourseById(courseId);
    }
}
