package com.example.springcruddemo.dao;

import com.example.springcruddemo.bean.Course;
import com.example.springcruddemo.bean.ProfessorCourses;
import com.example.springcruddemo.bean.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ScheduleDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private final String ALL_SCHEDULES = "SELECT * FROM SCHEDULE";

//    private final String SCHEDULE_BY_ID = "SELECT * FROM SCHEDULE WHERE PROFESSOR_ID=? AND COURSE_ID=? AND SEMESTER=? AND YEAR=?";

    private final String ADD_SCHEDULE = "INSERT INTO SCHEDULE (PROFESSOR_ID,COURSE_ID,SEMESTER,YEAR) VALUES (?,?,?,?)";

    private final String DELETE_SCHEDULE = "DELETE FROM SCHEDULE WHERE PROFESSOR_ID=? AND COURSE_ID=? AND SEMESTER=? AND YEAR=?";

    public List<Schedule> getAllSchedules(){

        List<Schedule> schedules = jdbcTemplate.query(ALL_SCHEDULES,new BeanPropertyRowMapper<Schedule>(Schedule.class));
        return schedules;
    }



//    public Schedule getSchedule(Schedule schedule){
//        Schedule result =  jdbcTemplate.queryForObject(SCHEDULE_BY_ID,new BeanPropertyRowMapper<Schedule>(Schedule.class),new Object[]{schedule.getProfessor_id(),schedule.getCourse_id(),schedule.getSemester(),schedule.getYear()});
//
//        return result;
//    }

    public Schedule addSchedule(Schedule schedule){

        int res = jdbcTemplate.update(ADD_SCHEDULE,new Object[]{schedule.getProfessor_id(),schedule.getCourse_id(),schedule.getSemester(),schedule.getYear()});
        if(res==1)
            return schedule;
        else
            return null;
    }

    public String removeSchedule(Schedule schedule)
    {

        int res = jdbcTemplate.update(DELETE_SCHEDULE,new Object[]{schedule.getProfessor_id(),schedule.getCourse_id(),schedule.getSemester(),schedule.getYear()});
        if(res ==1)
            return "Schedule with professor_id : "+schedule.getProfessor_id()+" course_id : "+ schedule.getCourse_id()+" semester : "+ schedule.getSemester()+" year : "+ schedule.getYear()+" deleted successfully";
        else
            return "Schedule with professor_id : "+schedule.getProfessor_id()+" course_id : "+ schedule.getCourse_id()+" semester : "+ schedule.getSemester()+" year : "+ schedule.getYear()+" deleted successfully"+" not found";
    }

}
