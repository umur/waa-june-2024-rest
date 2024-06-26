package com.miu.edu.service;

import com.miu.edu.entity.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {
     List<Course> getAllCourses();

     Optional<Course> getCourseById(Long id);

     void addCourse(Course course);

    void updateCourse(Course course);

    void deleteCourse(Long id);
}
