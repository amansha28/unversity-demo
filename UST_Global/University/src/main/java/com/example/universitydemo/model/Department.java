package com.example.universitydemo.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "department")
public class Department {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Professor> professors;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Course> courses;

    public Department() {
    }
    public Department(String name, List<Professor> professors, List<Course> courses) {
        this.name = name;
        this.professors = professors;
        this.courses = courses;
    }

    public Department(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Department(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
