package com.example.lab2.service.impl;

import com.example.lab2.entity.Course;
import com.example.lab2.repository.CourseRepo;
import com.example.lab2.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepo courseRepo;

    @Override
    public void save(Course course) {
        if (course.getCode() == null || course.getName() == null) {
            throw new IllegalArgumentException("Course name and code must not be null");
        }
        courseRepo.save(course);
    }

    @Override
    public List<Course> getAll() {
        return courseRepo.getAll();
    }

    @Override
    public void updateCourseById(int id, Course course) {
        courseRepo.updateCourseById(id, course);
    }

    @Override
    public void deleteCourseById(int id) {
        courseRepo.deleteCourseById(id);
    }
}
