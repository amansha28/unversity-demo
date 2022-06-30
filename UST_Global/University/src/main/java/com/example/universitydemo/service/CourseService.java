package com.example.universitydemo.service;

import com.example.universitydemo.dao.CourseRepo;
import com.example.universitydemo.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    CourseRepo courseRepo;

    public List<Course> getAllCourses() {
        return courseRepo.findAll();
    }

    public Course addCourse(Course course) {
        return courseRepo.save(course);
    }

    public void removeCourseById(@PathVariable("id") int courseId) {
        Optional<Course> tempCourse = courseRepo.findById(courseId);

        if (!tempCourse.isPresent()) {
            throw new RuntimeException("Course with id {" + courseId + "} is not found");
        }
        courseRepo.delete(tempCourse.get());
    }

}
