package waa.lab2_restservice.service;

import waa.lab2_restservice.entity.Course;

import java.util.List;

public interface CourseService {
    void save(Course course);
    Course getById(int id);
    List<Course> getAll();
    Course updateById(int id,Course course);
    void deleteById(int id);
}
