package com.restlab.service;

import com.restlab.entity.Course;
import com.restlab.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    CourseRepository courseRepository;

    @Override
    public void createCourse(Course course) {
        courseRepository.createCourse(course);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.getAllCourses();
    }

    @Override
    public Course getCourseById(int id) {
        return courseRepository.getCourseById(id);
    }

    @Override
    public Course updateCourse(int id, Course course) {
        return courseRepository.updateCourse(id,course);
    }

    @Override
    public void deleteCourse(int id) {
        courseRepository.deleteCourseById(id);
    }
}
