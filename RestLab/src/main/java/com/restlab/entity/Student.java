package com.restlab.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Student {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private long gpa;
    private List<Course> coursesTaken;

    public Student(){}

    public Student(int id, String firstName, String lastName, String email, String major, long gpa, List<Course> coursesTaken) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.major = major;
        this.gpa = gpa;
        this.coursesTaken = coursesTaken;
    }
}
