package com.lab1.lab1.service.impl;

import com.lab1.lab1.entity.Course;
import com.lab1.lab1.repository.CourseRepository;
import com.lab1.lab1.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl  implements CourseService {
    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourseById(int id) {
        return courseRepository.findById(id);
    }

    @Override
    public void addCourse(Course course) {
         courseRepository.save(course);
    }

    @Override
    public void updateCourse(Course course) {
         courseRepository.update(course);
    }

    @Override
    public void deleteCourse(int id) {
        courseRepository.deleteById(id);

    }

}
