package edu.miu.rest.service.impl;

import edu.miu.rest.domain.Course;
import edu.miu.rest.repository.CourseRepository;
import edu.miu.rest.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.getCourses();
    }

    @Override
    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    @Override
    public void updateCourse(int id, Course course) {
        courseRepository.update(id, course);
    }

    @Override
    public void deleteCourse(int id) {
        courseRepository.deleteById(id);
    }

    @Override
    public Course getCourse(int id) {
        return courseRepository.getCourseById(id)
                .orElseThrow(()-> new RuntimeException("Course not found"));
    }
}
