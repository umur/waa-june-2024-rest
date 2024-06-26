package com.example.course_management_system.service;
import com.example.course_management_system.entity.Course;
import com.example.course_management_system.entity.Student;
import java.util.List;
public interface StudentService {
    List<Student> getAllStudents();
    Student getStudentById(int id);
    void addStudent(Student student);
    void updateStudent(int id, Student student);
    void deleteStudent(int id);
    List<Student> getStudentsByMajor(String major);
    List<Course> getCoursesByStudentId(int studentId);
}
