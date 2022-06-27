package com.example.springcruddemo.service;


import com.example.springcruddemo.bean.Course;
import com.example.springcruddemo.bean.Department;
import com.example.springcruddemo.dao.CourseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    CourseDao courseDao;

    public List<Course> getAllCourses(){
        return courseDao.getAllCourses();
    }

    public Course getCourseById(int id){
        return courseDao.getCourseById(id);
    }

    public Course addCourse(Course course){
        return courseDao.addCourse(course);
    }

    public String removeCourseById(int id){
        return courseDao.removeCourseById(id);
    }
}
