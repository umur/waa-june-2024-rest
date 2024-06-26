package cs544.lab2.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Student {
    private long id;
    private String firstname;
    private String lastname;
    private String email;
    private String major;
    private double  gpa;
    private List<Course> courses;
}
