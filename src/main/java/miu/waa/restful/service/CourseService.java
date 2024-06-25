package miu.waa.restful.service;

import miu.waa.restful.entity.Course;
import miu.waa.restful.entity.Student;

import java.util.List;

public interface CourseService {
    List<Course> getAll();
    Course getOne(int id);
    List<Course> getCoursesByStudentId(int studentId);

    Course create(Course course);
    void update(int id, Course course);
    void delete(int id);
}
