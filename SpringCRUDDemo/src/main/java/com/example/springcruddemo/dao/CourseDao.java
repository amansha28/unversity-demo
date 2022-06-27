package com.example.springcruddemo.dao;


import com.example.springcruddemo.bean.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseDao {


    private final String ALL_COURSES = "SELECT * FROM COURSE";

    private final String COURSE_BY_ID = "SELECT * FROM COURSE WHERE ID=?";

    private final String ADD_COURSE = "INSERT INTO COURSE (ID,NAME,DEPARTMENT_ID,CREDITS) VALUES (?,?,?,?)";

    private final String DELETE_COURSE_BY_ID = "DELETE FROM COURSE WHERE ID = ?";

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Course> getAllCourses(){

        List<Course> course = jdbcTemplate.query(ALL_COURSES,new BeanPropertyRowMapper<Course>(Course.class));
        return course;
    }

    public Course getCourseById(int id){
        Course course = jdbcTemplate.queryForObject(COURSE_BY_ID,new BeanPropertyRowMapper<Course>(Course.class),new Object[]{id});

        return course;
    }

    public Course addCourse(Course course){

        int res = jdbcTemplate.update(ADD_COURSE,new Object[]{course.getId(),course.getName(),course.getDepartment_id(),course.getCredits()});
        if(res==1)
            return course;
        else
            return null;
    }

    public String removeCourseById(int id)
    {
        int res = jdbcTemplate.update(DELETE_COURSE_BY_ID,new Object[]{id});
        if(res ==1)
            return "Course with id : "+id+" deleted successfully";
        else
            return "Course with id : "+id+" not found";
    }

}
