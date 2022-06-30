package com.example.universitydemo.controller;


import com.example.universitydemo.model.Professor;
import com.example.universitydemo.model.ProfessorCoursesResult;
import com.example.universitydemo.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProfessorController {

    @Autowired
    ProfessorService professorService;

    @GetMapping("/professors")
    public List<Professor> getAllProfessor() {

        return professorService.getAllProfessors();
    }

    @PostMapping("/professors")
    public Professor addProfessor(@RequestBody Professor professor) {
        return professorService.addProfessor(professor);
    }

    @DeleteMapping("/professors/{id}")
    public void removeProfessor(@PathVariable("id") int profId) {
        professorService.removeProfessor(profId);
    }

    @GetMapping("/search")
    public List<ProfessorCoursesResult> getAllProfessorCourses() {
        return professorService.getAllProfessorCourses();
    }

}
