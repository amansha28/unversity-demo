package com.example.universitydemo.controller;

import com.example.universitydemo.dao.DepartmentDao;
import com.example.universitydemo.dao.ProfessorDao;
import com.example.universitydemo.model.Department;
import com.example.universitydemo.model.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    DepartmentDao departmentDao;

    @GetMapping("/departments")
    public List<Department> getAllDepartments(){
        return departmentDao.findAll();
    }

    @DeleteMapping("/departments/{dept_id}")
    public void removeDepartmentById(@PathVariable("dept_id") int dept_id)
    {
         departmentDao.deleteAllById(Collections.singleton(dept_id));
    }
}
