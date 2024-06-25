package com.example.demo.service;

import com.example.demo.entity.Course;
import com.example.demo.repository.CourseRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    public final CourseRepo courseRepo;

    public Course getCourseById(long id) {
        return courseRepo.getCourseById(id);
    }
    public List<Course> getAll() {
        return courseRepo.getAll();
    }
    public void createCourse(Course course) {
        courseRepo.createCourse(course);
    }
    public void updateCourse(Course course) {
        courseRepo.updateCourse(course);
    }
    public void deleteCourse(long id) {
        courseRepo.deleteCourse(id);
    }
}
