package restapi.service.course;

import restapi.domain.Course;

import java.util.List;

public interface CourseService {
    List<Course> findAll();

    Course getCourseById(Integer id);

    void createCourse(Course course);

    void updateCourse(Course course);

    void deleteCourse(Integer id);
}
