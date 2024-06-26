package Lab2.service;

import Lab2.domain.Course;
import Lab2.domain.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    List<Course> getCoursesByStudentId(int id);
    List<Student> getStudentByMajor(String major);
    void update(int id, Student student);
    Student findById(int id);
    void delete(int id);
    void save(Student student);
}
