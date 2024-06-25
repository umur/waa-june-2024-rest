package com.example.demo.service;

import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    public final StudentRepo studentRepo;

    public Student getStudentById(long id) {
        return studentRepo.getStudentById(id);
    }
    public List<Student> getAll() {
        return studentRepo.getAll();
    }
    public void createStudent(Student student) {
        studentRepo.createStudent(student);
    }
    public void updateStudent(Student student) {
        studentRepo.updateStudent(student);
    }
    public void deleteStudent(long id) {
        studentRepo.deleteStudent(id);
    }
    public List<Student> getStudentsByMajor(String major) {
        return studentRepo.getStudentsByMajor(major);
    }
    public List<Course> getCoursesByStudentId(long studentId) {
        return studentRepo.getCoursesByStudentId(studentId);
    }
}
