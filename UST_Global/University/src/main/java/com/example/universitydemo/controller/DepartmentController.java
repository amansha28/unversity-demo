package com.example.universitydemo.controller;

import com.example.universitydemo.model.Department;
import com.example.universitydemo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
    
    @Autowired
    DepartmentService departmentService;

    @GetMapping("/departments")
    public List<Department> getAllDepartments() {

        return departmentService.getAllDepartments();
    }

    @PostMapping("/departments")
    public Department addDepartment(@RequestBody Department department) {
        return departmentService.addDepartment(department);
    }

    @DeleteMapping("/departments/{deptId}")
    public void removeDepartmentById(@PathVariable("deptId") int deptId) {
        departmentService.removeDepartmentById(deptId);
    }
}
