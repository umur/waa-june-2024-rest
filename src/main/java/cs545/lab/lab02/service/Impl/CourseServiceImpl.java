package cs545.lab.lab02.service.Impl;

import cs545.lab.lab02.domain.Course;
import cs545.lab.lab02.domain.Student;
import cs545.lab.lab02.repository.CourseRepo;
import cs545.lab.lab02.repository.StudentRepo;
import cs545.lab.lab02.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepo courseRepo;
    private final StudentRepo studentRepo;

    @Override
    public Course addCourse(Course course) {
        return courseRepo.saveCourse(course);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepo.getAllCourses();
    }

    @Override
    public Course getCourseById(int id) {
        return courseRepo.getCourseById(id);
    }

    @Override
    public Course updateCourse(Course course) {
        return courseRepo.saveCourse(course);
    }

    @Override
    public void deleteCourse(int id) {
        courseRepo.deleteCourseById(id);
    }

    @Override
    public List<Course> getCoursesByStudentId(int id) {
        Student std = studentRepo.getStudent(id);
        return std.getCoursesTaken();
    }
}
