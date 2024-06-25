package waa.lab2_restservice.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private String gpa;
    private List<Course> coursesTaken = new ArrayList<>();

    public Student(int id, String firstName, String lastName, String email, String major, String gpa,List<Course> courses) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.major = major;
        this.gpa = gpa;
        this.coursesTaken = courses;
    }

    public void addCoursesTaken(Course course){
        this.coursesTaken.add(course);
    }
}
