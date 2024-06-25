package edu.miu.waa_june_2024_rest.service.impl;

import edu.miu.waa_june_2024_rest.entity.Course;
import edu.miu.waa_june_2024_rest.entity.Student;
import edu.miu.waa_june_2024_rest.repository.CourseRepository;
import edu.miu.waa_june_2024_rest.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author kush
 */
@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Override
    public Course save(Course course) {
        if(course.getId()<1){
            throw new RuntimeException("Ids cant be less than 1");
        }
        Course existingCourse=courseRepository.getById(course.getId());
        if(Objects.nonNull(existingCourse)){
            throw new RuntimeException("Course exists already");
        }
        return courseRepository.save(course);
    }

    @Override
    public Course update(int id, Course course) {
        if(id!=course.getId()){
            throw new RuntimeException("Invalid course supplied");
        }
        Course existingCourse=courseRepository.getById(course.getId());
        if(Objects.isNull(existingCourse)){
            throw new RuntimeException("No such course exists");
        }
        existingCourse.setCode(course.getCode());
        existingCourse.setName(course.getName());
        return courseRepository.update(existingCourse);
    }

    @Override
    public boolean delete(int id) {
        Course course= courseRepository.getById(id);
        if(Objects.isNull(course)){
            throw new RuntimeException("No course Found");
        }
        return courseRepository.deleteById(id);
    }

    @Override
    public List<Course> getAll() {
        return courseRepository.getAll();
    }

    @Override
    public Course getById(int id) {
        Course course= courseRepository.getById(id);
        if(Objects.isNull(course)){
            throw new RuntimeException("No course Found");
        }
        return course;
    }

    @Override
    public List<Course> getByIds(List<Integer> ids) {
        return courseRepository.getByIds(ids);
    }
}
