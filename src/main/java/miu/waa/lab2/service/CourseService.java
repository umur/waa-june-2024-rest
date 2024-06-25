package miu.waa.lab2.service;

import miu.waa.lab2.entity.Course;

import java.util.List;

public interface CourseService {
    Boolean create(Course course);
    List<Course> getAll();
    Course getCourseById(Long id);
    Course update(Long id, Course CourseDetails);
    boolean deleteCourseById(Long id);
}
