package miu.waa.lab2.service.impl;

import lombok.RequiredArgsConstructor;
import miu.waa.lab2.entity.Course;
import miu.waa.lab2.repository.CourseRepository;
import miu.waa.lab2.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    @Override
    public Boolean create(Course course) {
        return courseRepository.create(course);
    }

    @Override
    public List<Course> getAll() {
        return courseRepository.getAllCourses();
    }

    @Override
    public Course getCourseById(Long id) {
        return courseRepository.getCourseById(id);
    }

    @Override
    public Course update(Long id, Course CourseDetails) {
        return courseRepository.update(id, CourseDetails);
    }

    @Override
    public boolean deleteCourseById(Long id) {
        return courseRepository.deleteCourseById(id);
    }
}