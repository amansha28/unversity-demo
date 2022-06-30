package com.example.universitydemo.dao;

import com.example.universitydemo.model.ProfessorCourses;
import com.example.universitydemo.model.Schedule;
import com.example.universitydemo.model.ScheduleId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepo extends JpaRepository<Schedule, ScheduleId> {


    @Query(value = "select distinct(p.Name) as name , c.Name as courses\n" +
            "from schedule s\n" +
            "inner join Professor p on p.id = s.professor_id\n" +
            "inner join Course c on c.id = s.course_id\n" +
            "order by p.name,c.name;", nativeQuery = true)
    List<ProfessorCourses> getAllProfessorCourses();

}
