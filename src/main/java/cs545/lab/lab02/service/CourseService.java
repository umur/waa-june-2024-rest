package cs545.lab.lab02.service;

import cs545.lab.lab02.domain.Course;

import java.util.List;

public interface CourseService {

    Course addCourse(Course course);

    List<Course> getAllCourses();

    Course getCourseById(int id);

    Course updateCourse(Course course);

    void deleteCourse(int id);

    List<Course> getCoursesByStudentId(int id);
}
