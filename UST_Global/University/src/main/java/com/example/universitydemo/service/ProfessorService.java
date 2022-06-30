package com.example.universitydemo.service;

import com.example.universitydemo.dao.DepartmentRepo;
import com.example.universitydemo.dao.ProfessorRepo;
import com.example.universitydemo.dao.ScheduleRepo;
import com.example.universitydemo.model.Professor;
import com.example.universitydemo.model.ProfessorCourses;
import com.example.universitydemo.model.ProfessorCoursesResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProfessorService {

    @Autowired
    ProfessorRepo professorRepo;

    @Autowired
    ScheduleRepo scheduleRepo;

    @Autowired
    DepartmentRepo departmentRepo;


    public List<Professor> getAllProfessors() {
        return professorRepo.findAll();
    }

    public Professor addProfessor(Professor professor) {

        return professorRepo.save(professor);
    }

    public void removeProfessor(int profId) {
        Optional<Professor> tempProf = professorRepo.findById(profId);

        if (!tempProf.isPresent()) {
            throw new RuntimeException("Professor with id {" + profId + "} is not found");
        }

        professorRepo.delete(tempProf.get());
    }

    public List<ProfessorCoursesResult> getAllProfessorCourses() {
        Map<String, Set<String>> resultMap = new HashMap<>();
        List<ProfessorCourses> list = scheduleRepo.getAllProfessorCourses();
        for (int i = 0; i < list.size(); i++) {
            ProfessorCourses tempCourse = list.get(i);
            if (!resultMap.containsKey(tempCourse.getName())) {
                resultMap.put(tempCourse.getName(), tempCourse.getCourses());
            } else {
                Set<String> tempSet = resultMap.get(tempCourse.getName());
                tempSet.addAll(tempCourse.getCourses());
                resultMap.put(tempCourse.getName(), tempSet);
            }
        }

        List<ProfessorCoursesResult> profCoursesList = new ArrayList<>();
        for (Map.Entry<String, Set<String>> entry : resultMap.entrySet())
            profCoursesList.add(new ProfessorCoursesResult(entry.getKey(), entry.getValue()));

        return profCoursesList;
    }
}
