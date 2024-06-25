package org.example.restwebservices.service;

import com.example.earest.model.Course;
import com.example.earest.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
@AllArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course createCourse(Course course) {
        return courseRepository.create(course);
    }

    public Optional<Course> getCourseById(int id) {
        return courseRepository.findById(id);
    }

    public Optional<Course> updateCourse(int id, Course course) {
        return courseRepository.update(id, course);
    }

    public void deleteCourse(int id) {
        courseRepository.delete(id);
    }
}
