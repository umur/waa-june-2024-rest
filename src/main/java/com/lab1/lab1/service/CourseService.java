package com.lab1.lab1.service;

import com.lab1.lab1.entity.Course;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourses();
    Course getCourseById(int id);
    void addCourse(Course course);
    void updateCourse(Course course);
    void deleteCourse(int id);
}
