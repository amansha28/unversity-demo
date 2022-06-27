package com.example.springcruddemo.dao;

import com.example.springcruddemo.bean.Professor;
import com.example.springcruddemo.bean.ProfessorCourseRepo;
import com.example.springcruddemo.bean.ProfessorCourseResultSetExtractor;
import com.example.springcruddemo.bean.ProfessorCourses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ProfessorDao {

    private final String ALL_PROFESSORS = "SELECT * FROM PROFESSOR";
    private final String PROFESSOR_BY_ID = "SELECT * FROM PROFESSOR WHERE ID = ?";
    private final String ADD_PROFESSOR = "INSERT INTO PROFESSOR (ID,NAME, DEPARTMENT_ID) VALUES (?,?,?)";

    private final String DELETE_PROFESSOR_BY_ID = "DELETE FROM PROFESSOR WHERE ID = ?";

    private final String ALL_PROFESSOR_COURSES = "select distinct(p.Name) as name , c.Name as courses from schedule s left join Professor p on p.id = s.professor_id inner join Department d on d.id = p.department_id left join Course c on c.id = s.course_id order by p.name,c.name";
    @Autowired
    JdbcTemplate jdbcTemplate;

//    @Autowired
//    ProfessorCourseRepo professorCourseRepo;

    public List<Professor> getAllProfessors()
    {
        List<Professor> profs = jdbcTemplate.query(ALL_PROFESSORS,new BeanPropertyRowMapper<Professor>(Professor.class));
        return profs;
    }

    public Professor getProfessorById(int id){
        Professor prof = jdbcTemplate.queryForObject(PROFESSOR_BY_ID,new BeanPropertyRowMapper<Professor>(Professor.class),new Object[] {id});
        return prof;
    }

    public Professor addProfessor(Professor professor){
        int res = jdbcTemplate.update(ADD_PROFESSOR, new Object[]{
                professor.getId(),
                professor.getName(),
                professor.getDepartment_id()
        });

        if(res ==1)
            return professor;
        else
            return null;
    }

    public String deleteProfessorById(int id)
    {
        int res = jdbcTemplate.update(DELETE_PROFESSOR_BY_ID,new Object[] {id});
        if(res ==1)
            return "Professor with id : "+id+" deleted successfully";
        else
            return "Professor with id : "+id+" not found";
    }

//    public List<ProfessorCourses> getAllProfessorCourses(){
//
//        List<ProfessorCourses> list;
//
////            ProfessorCourses prof = new ProfessorCourses();
////            prof.setName("Frida Mcintosh");
////            Set<String> set = new HashSet<>();
////            set.add("Clinical Biochemistry");
////            prof.setCourses(set);
////            list.add(prof);
////        list = jdbcTemplate.query(ALL_PROFESSOR_COURSES,new ProfessorCourseResultSetExtractor());
//        list = professorCourseRepo.getAllProfessorCourses();
//        return list;
//    }

}
