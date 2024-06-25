package edu.miu.waa_june_2024_rest.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author kush
 */
@Getter
@Setter
public class Student {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private double gpa;
    private List<Course> coursesTaken;
}
