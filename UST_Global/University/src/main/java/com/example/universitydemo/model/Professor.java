package com.example.universitydemo.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PROFESSOR")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private Department department;

    // Case :1 - create corresponding dept is it doesnt exists.
    //    @ManyToOne(cascade = CascadeType.ALL)
    // Case 2 : dept should exist, else gives EntityNotFoundException
    @OneToMany
    // Case 3 : This cen be used creating extra tables of PROFESSOR_SCHEDULES
    //    @OneToMany(mappedBy = "professor",cascade = CascadeType.ALL)
    private List<Schedule> schedules;


    public Professor() {
    }

    public Professor(String name, Department department) {
        this.name = name;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department=" + department +
                '}';
    }
}
