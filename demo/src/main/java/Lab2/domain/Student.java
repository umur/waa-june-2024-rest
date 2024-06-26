package Lab2.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Student {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private double gpa;

    public Student(long id, String firstName, String lastName, String email, String major, double gpa) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.major = major;
        this.gpa = gpa;
    }

    private List<Course> courses = new ArrayList<>();

    public void addCourse(Course course){
        courses.add(course);
    }
}
