package com.lab1.lab1.service;

import com.lab1.lab1.entity.Course;
import com.lab1.lab1.entity.Student;

import java.util.List;

public interface StudentService {

    void addStudent(Student student);
    List<Student> getAllStudents();
    Student getStudentById(int id);
    void deleteStudentById(int id);
    Student updateStudent(Student student);
    List<Student> getStudentsByMajor(String major);
    List<Course> getCoursesByStudentId(int studentId);
}
