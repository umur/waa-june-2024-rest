package com.example.course_management_system.repository;
import com.example.course_management_system.entity.Course;
import java.util.List;
public interface CourseRepository {
    List<Course> findAll();
    Course findById(int id);
    void save(Course course);
    void update(int id, Course course);
    void deleteById(int id);
}
