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

//    @ManyToOne(cascade = CascadeType.ALL) // Case :1 - create corresponding dept is it doesnt exists.
    @ManyToOne // Case 2 : dept should exist, else gives EntityNotFoundException
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private Department department;

    @OneToMany
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
