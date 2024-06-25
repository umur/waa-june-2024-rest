package waa.lab2_restservice.service;

import waa.lab2_restservice.entity.Course;
import waa.lab2_restservice.entity.Student;

import java.util.List;

public interface StudentService {
    void save(Student student);
    Student getById(int id);
    List<Student> getAll();
    Student updateById(int id,Student student);
    void deleteById(int id);
    List<Student> getStudentsByMajor(String major);
    List<Course> getCoursesByStudentId(int studentId);
}
