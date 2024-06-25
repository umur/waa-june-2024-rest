package com.miu.waa.service.course;

import com.miu.waa.entity.Course;
import com.miu.waa.repository.CourseRepository;
import com.miu.waa.repository.GenericRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Override
    public List<Course> findAll() {
        return courseRepository.getCourses();
    }

    @Override
    public Course find(Long id) {
        return courseRepository.findById(id);
    }

    @Override
    public void save(Course course) {
        courseRepository.add(course);
    }

    @Override
    public void update(Course course) {
        courseRepository.update(course);
    }

    @Override
    public void delete(Course course) {
        courseRepository.deleteById(course.getId());
    }
}
