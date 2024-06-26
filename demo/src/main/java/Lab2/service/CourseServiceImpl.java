package Lab2.service;

import Lab2.domain.Course;
import Lab2.repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseRepo courseRepo;

    public void save(Course course){
        courseRepo.addCourse(course);
    }
    public List<Course> getCourses(){
        return courseRepo.getCourses();
    }
    public Course getCourse(int id){
        Course course = courseRepo.getCourse(id);
        if(course == null){
            throw new RuntimeException("Course not found");
        }
        return courseRepo.getCourse(id);
    }
    public void deleteCourse(int id){
        Course course = courseRepo.getCourse(id);
        if(course == null){
            throw new RuntimeException("Course not found");
        }
        courseRepo.removeCourse(id);
    }
    public void updateCourse(int id, Course course){
        Course course1 = courseRepo.getCourse(id);
        if(course1 == null){
            throw new RuntimeException("Course not found");
        }
        course1.setName(course.getName());
        course1.setId(course.getId());
        course1.setCode(course.getCode());
        courseRepo.updateCourse(id, course1);
    }
}
