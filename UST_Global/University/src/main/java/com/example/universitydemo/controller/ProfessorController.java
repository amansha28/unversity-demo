package com.example.universitydemo.controller;


import com.example.universitydemo.dao.ProfessorDao;
import com.example.universitydemo.dao.ScheduleDao;
import com.example.universitydemo.model.Professor;
import com.example.universitydemo.model.ProfessorCourses;
import com.example.universitydemo.model.ProfessorCoursesResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class ProfessorController {

    @Autowired
    ProfessorDao professorDao;

    @Autowired
    ScheduleDao scheduleDao;

    @GetMapping("/professors")
    public List<Professor> getAllProfessor(){
        return professorDao.findAll();
    }

    @GetMapping("/search")
    public List<ProfessorCoursesResult> getAllProfessorCourses(){
        Map<String, Set<String>> resultMap = new HashMap<>();
        List<ProfessorCourses> list =  scheduleDao.getAllProfessorCourses();
        for(int i=0;i<list.size();i++)
        {
            ProfessorCourses tempCourse = list.get(i);
            if(!resultMap.containsKey(tempCourse.getName())){
                resultMap.put(tempCourse.getName(),tempCourse.getCourses());
            }else{
                Set<String> tempSet = resultMap.get(tempCourse.getName());
                tempSet.addAll(tempCourse.getCourses());
                resultMap.put(tempCourse.getName(),tempSet);
            }
        }

        List<ProfessorCoursesResult> profCoursesList = new ArrayList<>();
        for (Map.Entry<String,Set<String>> entry : resultMap.entrySet())
            profCoursesList.add(new ProfessorCoursesResult(entry.getKey(), entry.getValue()));

        System.out.println("Size : "+profCoursesList.size());
        return profCoursesList;
    }

}
