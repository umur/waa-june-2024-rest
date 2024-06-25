package com.example.lab2.service;

import com.example.lab2.entity.Course;
import com.example.lab2.entity.Student;

import java.util.List;

public interface StudentService {
    void save(Student student);

    List<Student> getAll(String major);

    void updateStudentById(int id, Student student);

    void deleteStudentById(int id);

    List<Course> getCoursesByStudentId(int studentId);
}
