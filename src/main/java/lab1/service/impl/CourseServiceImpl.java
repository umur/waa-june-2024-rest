package lab1.service.impl;

import lab1.entity.Course;
import lab1.repository.CourseRepository;
import lab1.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;


    @Override
    public void save(Course course) {

        if(course.getName() == null || course.getName().isEmpty()){
            throw new RuntimeException("Course name cannot be empty");
        }
        courseRepository.save(course);
    }

    @Override
    public Course getCourse(int id) {

        Course result=courseRepository.findById(id);

        if(result==null || result.getName().isEmpty()){
            throw new RuntimeException("Course name cannot be found");
        }
        return result;
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public void deleteCourse(int id) {
        boolean result=courseRepository.deleteById(id);

        if(!result){
            throw new RuntimeException("Course cannot be found");
        }
    }

    @Override
    public void updateCourse(int id,Course course) {
        courseRepository.update(id,course);
    }
}
