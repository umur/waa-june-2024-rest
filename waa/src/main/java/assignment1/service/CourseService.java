package assignment1.service;

import assignment1.domain.Course;

import java.util.List;

public interface CourseService {
    List<Course> findAll();
    Course findById(int id);
    void save(Course course);
    void update(Course course);
    void delete(int id);
}
