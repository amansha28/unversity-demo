package com.example.springcruddemo.controller;

import com.example.springcruddemo.bean.Department;
import com.example.springcruddemo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @GetMapping("/departments")
    public List<Department> getAllDepartments(){
        return departmentService.getAllDepartments();
    }

    @GetMapping("/departments/{id}")
    public Department getDepartmentById(@PathVariable("id") int id){
        return departmentService.getDepartmentById(id);
    }

    @PostMapping("/departments")
    public Department addDepartment(@RequestBody Department dept)
    {
        return departmentService.addDepartment(dept);
    }

    @DeleteMapping("/departments/{id}")
    public String removeDepartmentById(@PathVariable("id") int id){
        return departmentService.removeDepartmentById(id);
    }
}
