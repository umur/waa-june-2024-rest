package com.restlab.service;

import com.restlab.entity.Course;
import com.restlab.entity.Student;

import java.util.List;

public interface StudentService {

    void createStudent(Student student);

    List<Student> getAllStudents();

    Student getStudentById(int id);

    Student updateStudentById(int id,Student student);

    void deleteStudent(int id);

    List<Student> getStudentsByMajor(String major);

    List<Course> getCoursesByStudentId(int studentId);
}
