package Lab2.service;

import Lab2.domain.Course;

import java.util.List;

public interface CourseService {
    void updateCourse(int id, Course course);
    void deleteCourse(int id);
    Course getCourse(int id);
    List<Course> getCourses();
    void save(Course course);
}
