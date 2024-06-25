package edu.miu.rest.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Student {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private double gpa;
    private List<Course> coursesTaken = new ArrayList<>();
}
