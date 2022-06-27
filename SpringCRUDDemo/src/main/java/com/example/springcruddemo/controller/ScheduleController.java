package com.example.springcruddemo.controller;

import com.example.springcruddemo.bean.Course;
import com.example.springcruddemo.bean.Schedule;
import com.example.springcruddemo.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ScheduleController {

    @Autowired
    ScheduleService scheduleService;

    @GetMapping("/schedules")
    public List<Schedule> getAllSchedules(){
        return scheduleService.getAllSchedules();
    }

//    @GetMapping("/schedules/one")
//    public Schedule getSchedule(@RequestBody Schedule schedule){
//        return scheduleService.getSchedule(schedule);
//    }

    @PostMapping("/schedules")
    public Schedule addSchedule(@RequestBody Schedule schedule)
    {
        return scheduleService.addSchedule(schedule);
    }

    @DeleteMapping("/schedules")
    public String removeSchedule(@RequestBody Schedule schedule){
        return scheduleService.removeSchedule(schedule);
    }
}
