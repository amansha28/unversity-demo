package com.example.springcruddemo.controller;


import com.example.springcruddemo.bean.Professor;
import com.example.springcruddemo.bean.ProfessorCourseRepo;
import com.example.springcruddemo.bean.ProfessorCourses;
import com.example.springcruddemo.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProfessorController {

    @Autowired
    ProfessorService professorService;

    @Autowired
    ProfessorCourseRepo professorCourseRepo;

//    API to read
    @GetMapping("/professors")
    public List<Professor> getAllProfessors(){
        return professorService.getAllProfessors();
    }

    @GetMapping("/professors/{id}")
    public Professor getProfessorById(@PathVariable("id") int id)
    {
        return professorService.getProfessorById(id);
    }

//    API to create
    @PostMapping("/professors")
    public Professor addProfessor(@RequestBody Professor professor)
    {
        return professorService.addProfessor(professor);
    }

//    API to delete
    @DeleteMapping("/professors/{id}")
    public String deleteProfessorById(@PathVariable("id") int id)
    {
        return professorService.deleteProfessorById(id);
    }

    @GetMapping("/professors/search")
    public List<ProfessorCourses> getAllProfessorCourses(){
//        return professorService.getAllProfessorCourses();
        return professorCourseRepo.getAllProfessorCourses();
    }
}
