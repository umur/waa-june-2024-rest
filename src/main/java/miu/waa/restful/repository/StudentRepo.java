package miu.waa.restful.repository;

import miu.waa.restful.entity.Course;
import miu.waa.restful.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo extends DefaultRepository<Student> {
    {
        Student student = new Student(618001, "James", "Pete", "info@miu.edu", "Programming");

        List<Course> coursesTaken = new ArrayList<>() {{
            add(new Course(103, "Modern Web Application", "CS525"));
            add(new Course(104, "Web Application Architect", "CS545"));
        }};
        Student studentWithCourses = new Student(
                618002,
                "John",
                "Doe",
                "jdoe@miu.edu",
                "Data Analytics",
                coursesTaken
        );

        repo.addAll(List.of(student, studentWithCourses));
    };
}
