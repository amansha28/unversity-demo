package com.example.springcruddemo.service;

import com.example.springcruddemo.bean.Department;
import com.example.springcruddemo.dao.DepartmentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    DepartmentDao departmentDao;

    public List<Department> getAllDepartments(){
        return departmentDao.getAllDepartments();
    }

    public Department getDepartmentById(int id){
        return departmentDao.getDepartmentById(id);
    }

    public Department addDepartment(Department dept){
        return departmentDao.addDepartment(dept);
    }

    public String removeDepartmentById(int id){
        return departmentDao.removeDepartmentById(id);
    }
}
