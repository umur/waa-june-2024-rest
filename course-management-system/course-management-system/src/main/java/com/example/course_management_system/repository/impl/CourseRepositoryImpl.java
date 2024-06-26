package com.example.course_management_system.repository.impl;

import com.example.course_management_system.entity.Course;
import com.example.course_management_system.repository.CourseRepository;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Repository
public class CourseRepositoryImpl implements CourseRepository {
    private final List<Course> courses = new ArrayList<>();

    @Override
    public List<Course> findAll() {
        return courses;
    }

    @Override
    public Course findById(int id) {
        return courses.stream().filter(course -> course.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void save(Course course) {
        courses.add(course);
    }

    @Override
    public void update(int id, Course course) {
        Optional<Course> existingCourse = courses.stream().filter(c -> c.getId() == id).findFirst();
        existingCourse.ifPresent(c -> {
            c.setName(course.getName());
            c.setCode(course.getCode());
        });
    }

    @Override
    public void deleteById(int id) {
        courses.removeIf(course -> course.getId() == id);
    }
}
