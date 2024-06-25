package com.example.lab2.service;

import com.example.lab2.entity.Course;

import java.util.List;

public interface CourseService {
    void save(Course course);

    List<Course> getAll();

    void updateCourseById(int id, Course course);

    void deleteCourseById(int id);
}
