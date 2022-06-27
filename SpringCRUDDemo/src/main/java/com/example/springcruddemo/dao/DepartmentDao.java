package com.example.springcruddemo.dao;

import com.example.springcruddemo.bean.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartmentDao {

    private final String ALL_DEPARTS = "SELECT * FROM DEPARTMENT";

    private final String DEPT_BY_ID = "SELECT * FROM DEPARTMENT WHERE ID=?";

    private final String ADD_DEPT = "INSERT INTO DEPARTMENT (ID,NAME) VALUES (?,?)";

    private final String DELETE_DEPARTMENT_BY_ID = "DELETE FROM DEPARTMENT WHERE ID = ?";

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Department> getAllDepartments(){

        List<Department> depts = jdbcTemplate.query(ALL_DEPARTS,new BeanPropertyRowMapper<Department>(Department.class));
        return depts;
    }

    public Department getDepartmentById(int id){
        Department dept = jdbcTemplate.queryForObject(DEPT_BY_ID,new BeanPropertyRowMapper<Department>(Department.class),new Object[]{id});

        return dept;
    }

    public Department addDepartment(Department dept){

        int res = jdbcTemplate.update(ADD_DEPT,new Object[]{dept.getId(),dept.getName()});

        if(res==1)
            return dept;
        else
            return null;

    }

    public String removeDepartmentById(int id)
    {
        int res = jdbcTemplate.update(DELETE_DEPARTMENT_BY_ID,new Object[]{id});
        if(res ==1)
            return "Department with id : "+id+" deleted successfully";
        else
            return "Department with id : "+id+" not found";
    }

}
