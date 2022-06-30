package com.example.universitydemo.service;

import com.example.universitydemo.dao.DepartmentRepo;
import com.example.universitydemo.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepo departmentRepo;

    public List<Department> getAllDepartments() {

        return departmentRepo.findAll();
    }

    public Department addDepartment(Department department) {
        return departmentRepo.save(department);
    }

    public void removeDepartmentById(@PathVariable("deptId") int deptId) {
        Optional<Department> tempDept = departmentRepo.findById(deptId);

        if (!tempDept.isPresent()) {
            throw new RuntimeException("Department with id {" + deptId + "} is not found");
        }
        departmentRepo.delete(tempDept.get());
    }
}
