package com.example.course_management_system.repository;
import com.example.course_management_system.entity.Student;
import java.util.List;

public interface StudentRepository {
    List<Student> findAll();
    Student findById(int id);
    void save(Student student);
    void update(int id, Student student);
    void deleteById(int id);
    List<Student> findByMajor(String major);
}
