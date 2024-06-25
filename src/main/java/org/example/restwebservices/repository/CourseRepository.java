package org.example.restwebservices.repository;

import org.example.restwebservices.model.Course;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class CourseRepository {
    private static final List<Course> courses = new ArrayList<>();
    private static final AtomicInteger idGenerator = new AtomicInteger();

    public List<Course> findAll() {
        return courses;
    }

    public Course create(Course course) {
        course.setId(idGenerator.incrementAndGet()); // Simulate auto-increment ID
        courses.add(course);
        return course;
    }

    public Optional<Course> findById(int id) {
        return courses.stream()
                .filter(course -> course.getId() == id)
                .findFirst();
    }

    public Optional<Course> update(int id, Course updatedCourse) {
        return findById(id).map(course -> {
            course.setName(updatedCourse.getName());
            course.setCode(updatedCourse.getCode());

            return course;
        });
    }

    public void delete(int id) {
        courses.removeIf(course -> course.getId() == id);
    }
}
