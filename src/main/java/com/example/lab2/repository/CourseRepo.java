package com.example.lab2.repository;

import com.example.lab2.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepo {
    private static final List<Course> courses = new ArrayList<>();

    public void save(Course course) {
        courses.add(course);
    }

    public List<Course> getAll() {
        return courses;
    }

    public Course getCourseById(int id) {
        for (Course course : courses) {
            if (course.getId() == id) {
                return course;
            }
        }
        return null;
    }

    public void deleteCourseById(int id) {
        Course course = getCourseById(id);
        courses.remove(course);
    }

    public void updateCourseById(int id, Course course) {
        Course courseToUpdate = getCourseById(id);
        if (courseToUpdate == null) {
            return;
        }
        courseToUpdate.setName(course.getName());
        courseToUpdate.setCode(course.getCode());
    }
}
