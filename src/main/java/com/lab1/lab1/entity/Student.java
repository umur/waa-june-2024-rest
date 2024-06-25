package com.lab1.lab1.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private int gpa;
    private List<Course> coursesTaken = new ArrayList<>();

    public void addCourse(Course course) {
        coursesTaken.add(course);
    }
}
