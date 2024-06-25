package assignment1.service;

import assignment1.domain.Course;
import assignment1.domain.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAll();
    Student getById(int id);
    void save(Student student);
    void update(Student student);
    void delete(int id);
    List<Student> findByMajor(String major);
    List<Course> getStudentCourses(int studentId);
}
