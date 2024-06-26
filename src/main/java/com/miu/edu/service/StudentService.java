package com.miu.edu.service;

import com.miu.edu.entity.Course;
import com.miu.edu.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> getAllStudents();

    Optional<Student> getStudentById(Long id);

    void addStudent(Student student);

    void updateStudent(Student student);

    void deleteStudent(Long id);

    List<Student> getStudentsByMajor(String major);

    List<Course> getCoursesByStudentId(Long studentId);
}
