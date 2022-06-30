package com.example.universitydemo.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "SCHEDULE")
@IdClass(ScheduleId.class)
public class Schedule {

    @Id
    private int course_id;

    @Id
    private int professor_id;


    // This can be used with Case 3 as mentioned in Professor and Course Entity classes.
  /*  @Id
    @ManyToOne()
    private Professor professor;


    @Id
    @ManyToOne()
    private Course course;*/

    @Id
    private int semester;
    @Id
    private int year_taught;

    public Schedule() {
    }

    public Schedule(int course_id, int professor_id, int semester, int year_taught) {
        this.course_id = course_id;
        this.professor_id = professor_id;
        this.semester = semester;
        this.year_taught = year_taught;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public int getProfessor_id() {
        return professor_id;
    }

    public void setProfessor_id(int professor_id) {
        this.professor_id = professor_id;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getYear_taught() {
        return year_taught;
    }

    public void setYear_taught(int year_taught) {
        this.year_taught = year_taught;
    }
}
