package com.example.springcruddemo.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProfessorCourseRepo extends JpaRepository<ProfessorCourses,String> {



    @Query(value="select distinct(p.Name) as name , c.Name as courses from schedule s left join Professor p on p.id = s.professor_id inner join Department d on d.id = p.department_id left join Course c on c.id = s.course_id order by p.name,c.name",nativeQuery = true)
    List<ProfessorCourses> getAllProfessorCourses();
}
