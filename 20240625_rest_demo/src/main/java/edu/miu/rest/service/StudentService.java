package edu.miu.rest.service;

import edu.miu.rest.domain.Course;
import edu.miu.rest.domain.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> findAll();

    Student findById(int id);

    List<Student> getStudentsByMajor(String major);

    List<Course> getCoursesByStudentId(int studentId);

    void save(Student student);

    void update(int id, Student student);

    void deleteStudentById(int id);
}
