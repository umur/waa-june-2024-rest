package com.lab1.lab1.repository;

import com.lab1.lab1.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepository {
    private final List<Course> courses = new ArrayList<>();

    public List<Course> findAll() {
        return courses;
    }
    public void save(Course course) {
        courses.add(course);
    }
    public Course findById(int id) {
        return courses.stream().filter(course -> course.getId() == id).findFirst().orElse(null);
    }

    public void deleteById(int id) {
        courses.removeIf(course -> course.getId() == id);
    }

    public void update(Course course) {
        courses.replaceAll(c -> c.getId() == course.getId() ? course : c);
    }

}
