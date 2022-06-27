package com.example.springcruddemo.bean;

public class Schedule {

    private int professor_id;
    private int course_id;
    private int semester;
    private int year;

    public Schedule() {
    }

    public Schedule(int professor_id, int course_id, int semester, int year) {
        this.professor_id = professor_id;
        this.course_id = course_id;
        this.semester = semester;
        this.year = year;
    }

    public int getProfessor_id() {
        return professor_id;
    }

    public void setProfessor_id(int professor_id) {
        this.professor_id = professor_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "professor_id=" + professor_id +
                ", course_id=" + course_id +
                ", semester=" + semester +
                ", year=" + year +
                '}';
    }
}
