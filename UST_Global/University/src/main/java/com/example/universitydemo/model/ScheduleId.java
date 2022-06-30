package com.example.universitydemo.model;

import java.io.Serializable;
import java.util.Objects;

public class ScheduleId implements Serializable {

//    private int professor;
//
//    private int course;

    private int professor_id;
    private int course_id;
    private int semester;
    private int year_taught;

    public ScheduleId() {
    }

    public ScheduleId(int professor_id, int course_id, int semester, int year_taught) {
        this.professor_id = professor_id;
        this.course_id = course_id;
        this.semester = semester;
        this.year_taught = year_taught;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScheduleId that = (ScheduleId) o;
        return professor_id == that.professor_id && course_id == that.course_id && semester == that.semester && year_taught == that.year_taught;
    }

    @Override
    public int hashCode() {
        return Objects.hash(professor_id, course_id, semester, year_taught);
    }
}
