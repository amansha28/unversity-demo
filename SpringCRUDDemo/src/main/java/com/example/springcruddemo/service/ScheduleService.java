package com.example.springcruddemo.service;

import com.example.springcruddemo.bean.Course;
import com.example.springcruddemo.bean.Schedule;
import com.example.springcruddemo.dao.ScheduleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {

    @Autowired
    ScheduleDao scheduleDao;


    public List<Schedule> getAllSchedules(){
        return scheduleDao.getAllSchedules();
    }

//    public Schedule getSchedule(Schedule schedule){
//        return scheduleDao.getSchedule(schedule);
//    }

    public Schedule addSchedule(Schedule schedule){
        return scheduleDao.addSchedule(schedule);
    }

    public String removeSchedule(Schedule schedule){
        return scheduleDao.removeSchedule(schedule);
    }
}
