package com.example.universitydemo.service;

import com.example.universitydemo.dao.ScheduleRepo;
import com.example.universitydemo.model.Schedule;
import com.example.universitydemo.model.ScheduleId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleService {

    @Autowired
    ScheduleRepo scheduleRepo;

    public List<Schedule> getAllSchedules() {
        return scheduleRepo.findAll();
    }

    public Schedule addSchedules(Schedule schedule) {
        return scheduleRepo.save(schedule);
    }


    public void removeSchedulesById(int course_id, int professor_id, int semester, int year_taught) {
        Optional<Schedule> tempSchedule = scheduleRepo.findById(new ScheduleId(professor_id, course_id, semester, year_taught));
        if (!tempSchedule.isPresent()) {
            throw new RuntimeException("Schedule not found");
        } else
            scheduleRepo.deleteById(new ScheduleId(professor_id, course_id, semester, year_taught));
    }
}
