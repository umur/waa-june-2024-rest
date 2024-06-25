package waa.lab2_restservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import waa.lab2_restservice.entity.Course;
import waa.lab2_restservice.repository.CourseRepository;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CouseServiceImpl implements CourseService{
    final CourseRepository courseRepository;

    @Override
    public void save(Course course) {
        courseRepository.save(course);
    }

    @Override
    public Course getById(int id) {
        Course course = courseRepository.getById(id);
        if(course==null){
            throw new RuntimeException("Course not found with id:"+id);
        }
        return course;
    }

    @Override
    public List<Course> getAll() {
        return courseRepository.getAll();
    }

    @Override
    public Course updateById(int id, Course course) {
        Course result = courseRepository.updateById(id,course);
        if(result==null){
            throw new RuntimeException("Course not found with id:"+id);
        }
        return result;
    }

    @Override
    public void deleteById(int id) {
        if(!courseRepository.deleteById(id)){
            throw new RuntimeException("Course not found with id:"+id);
        }
    }
}
