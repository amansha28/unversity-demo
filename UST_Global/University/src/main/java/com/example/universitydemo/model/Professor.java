package com.example.universitydemo.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="PROFESSOR")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @ManyToOne
    @JoinColumn(name="department_id", referencedColumnName = "id")
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
