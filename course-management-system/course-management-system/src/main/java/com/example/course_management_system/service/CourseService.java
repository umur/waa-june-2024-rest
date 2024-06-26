package com.example.course_management_system.service;
import com.example.course_management_system.entity.Course;
import java.util.List;

public interface CourseService {
    List<Course> getAllCourses();
    Course getCourseById(int id);
    void addCourse(Course course);
    void updateCourse(int id, Course course);
    void deleteCourse(int id);
}
