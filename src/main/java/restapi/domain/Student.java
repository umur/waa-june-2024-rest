package restapi.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
public class Student {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private Double gpa;

    private Set<Course> coursesTaken = new HashSet<>();
    public Student(String firstName, String lastName, String email, String major, Double gpa){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.major = major;
        this.gpa = gpa;
    }

    public void addCourse(Course course) {
        coursesTaken.add(course);
    }
}
