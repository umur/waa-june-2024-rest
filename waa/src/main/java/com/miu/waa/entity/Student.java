package com.miu.waa.entity;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Student {
    @NotNull
    private Long id;
    @NotNull
    @Size(min = 1, max = 20)
    private String firstName;
    @NotNull
    @Size(min = 1, max = 20)
    private String lastName;
    @Size(min = 1, max = 20)
    private String email;
    @NotNull
    @Size(min = 1, max = 20)
    private String major;
    @NotNull
    private double gpa;

    private List<Course> coursesTaken = new ArrayList<>();

    public void addCourse(Course course) {
        coursesTaken.add(course);
    }
}
