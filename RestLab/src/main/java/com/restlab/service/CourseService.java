package com.restlab.service;

import com.restlab.entity.Course;
import java.util.List;

public interface CourseService {

    void createCourse(Course course);

    List<Course> getAllCourses();

    Course getCourseById(int id);

    Course updateCourse(int id,Course course);

    void deleteCourse(int id);
}
