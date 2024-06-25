package miu.waa.restful.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Student {
    private final int id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String major;
    private double gpa;
    private final List<Course> coursesTaken;

    public Student(int id, String firstName, String lastName, String email, String major) {
        this(id, firstName, lastName, email, major, new ArrayList<>());
    }

    public Student(int id, String firstName, String lastName, String email, String major, List<Course> coursesTaken) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.major = major;
        this.coursesTaken = coursesTaken;
    }

    public void addCourse(Course course) {
        coursesTaken.add(course);
    }
}
