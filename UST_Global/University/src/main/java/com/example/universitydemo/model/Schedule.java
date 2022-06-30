package com.example.universitydemo.model;


import javax.persistence.*;
import java.util.List;

@Entity
@IdClass(ScheduleId.class)
public class Schedule {

    @Id
    private int professor_id;

    @Id
    private int course_id;


//    @Id
//    @ManyToOne()
//    private Professor professor;
//
//
//    @Id
//    @ManyToOne()
//    private Course course;

    @Id
    private int semester;
    @Id
    private int year_taught;

}
