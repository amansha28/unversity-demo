package com.example.springcruddemo.service;

import com.example.springcruddemo.bean.Professor;
import com.example.springcruddemo.bean.ProfessorCourses;
import com.example.springcruddemo.dao.ProfessorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {

    @Autowired
    ProfessorDao professorDao;

    public List<Professor> getAllProfessors(){
        return professorDao.getAllProfessors();
    }
    public Professor getProfessorById(int id){
        return professorDao.getProfessorById(id);
    }

    public Professor addProfessor(Professor professor)
    {
        return professorDao.addProfessor(professor);
    }

    public String deleteProfessorById(int id)
    {
        return  professorDao.deleteProfessorById(id);
    }

//    public List<ProfessorCourses> getAllProfessorCourses(){
//        return professorDao.getAllProfessorCourses();
//    }
}
