package edu.miu.cs545.lab2.repository;

import edu.miu.cs545.lab2.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepo {
    private final List<Course> courses = new ArrayList<>();

    public void save(Course course) {
        courses.add(course);
    }

    public List<Course> getAllCourses() {
        return courses;
    }

    public Course getCourse(int id) {
        return courses.stream().filter(course -> course.getId() == id).findFirst().orElse(null);
    }

    public void deleteCourse(int id) {
        courses.removeIf(course -> course.getId() == id);
    }

    public void updateCourse(Course course) {
        Course courseToUpdate = courses.stream().filter(c -> c.getId() == course.getId()).findFirst().orElse(null);
        if (courseToUpdate != null) {
            courseToUpdate.setName(course.getName());
            courseToUpdate.setCode(course.getCode());
        }
    }
}
