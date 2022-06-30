package com.example.universitydemo.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "COURSE")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private Department department;

    // Case :1 - create corresponding dept is it doesnt exists.
    //  @ManyToOne(cascade = CascadeType.ALL)

    // Case 2 : dept should exist, else gives EntityNotFoundException
    @OneToMany
    // Case 3 : This can be avoid creating extra tables of COURSE_SCHEDULES
    //  @OneToMany(mappedBy = "course",cascade = CascadeType.ALL)
    private List<Schedule> schedules;
    private int credits;

    public Course() {
    }

    public Course(int id, String name, int credits) {
        this.id = id;
        this.name = name;
        this.credits = credits;
    }

    public Course(int id, String name, Department department, List<Schedule> schedules, int credits) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.schedules = schedules;
        this.credits = credits;
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

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }
}
