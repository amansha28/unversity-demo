package com.example.universitydemo.controller;


import com.example.universitydemo.model.Schedule;
import com.example.universitydemo.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ScheduleController {

    @Autowired
    ScheduleService scheduleService;


    @GetMapping("/schedules")
    public List<Schedule> getAllSchedules() {
        return scheduleService.getAllSchedules();
    }

    @PostMapping("/schedules")
    public Schedule addSchedules(@RequestBody Schedule schedule) {
        return scheduleService.addSchedules(schedule);
    }


    @DeleteMapping("/schedules/{course_id}/{professor_id}/{semester}/{year_taught}")
    public void removeSchedulesById(@PathVariable int course_id,
                                    @PathVariable int professor_id,
                                    @PathVariable int semester,
                                    @PathVariable int year_taught) {
        scheduleService.removeSchedulesById(course_id, professor_id, semester, year_taught);
    }


}
