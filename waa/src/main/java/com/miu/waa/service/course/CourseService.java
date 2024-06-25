package com.miu.waa.service.course;

import com.miu.waa.entity.Course;

import java.util.List;

public interface CourseService {

    List<Course> findAll();
    Course find(Long id);
    void save(Course course);
    void update(Course course);
    void delete(Course course);
}
