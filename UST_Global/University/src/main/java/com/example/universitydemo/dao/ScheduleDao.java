package com.example.universitydemo.dao;

import com.example.universitydemo.model.ProfessorCourses;
import com.example.universitydemo.model.Schedule;
import com.example.universitydemo.model.ScheduleId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // Naming the Repo interface as Dao as I wanted to keep the code to minimum.
public interface ScheduleDao extends JpaRepository<Schedule, ScheduleId> {


    @Query(value = "select distinct(p.Name) as name , c.Name as courses \n" +
            "from schedule s \n" +
            "left join Professor p on p.id = s.professor_id \n" +
            "inner join Department d on d.id = p.department_id \n" +
            "left join Course c on c.id = s.course_id \n" +
            "order by p.name,c.name;",nativeQuery = true)
     List<ProfessorCourses> getAllProfessorCourses();
}
