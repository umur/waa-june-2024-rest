package edu.miu.rest.service;

import edu.miu.rest.domain.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourses();

    void addCourse(Course course);

    void updateCourse(int id, Course course);

    void deleteCourse(int id);

    Course getCourse(int id);
}
