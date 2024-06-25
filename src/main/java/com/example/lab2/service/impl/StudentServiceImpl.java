package com.example.lab2.service.impl;

import com.example.lab2.entity.Course;
import com.example.lab2.entity.Student;
import com.example.lab2.repository.StudentRepo;
import com.example.lab2.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepo studentRepo;

    @Override
    public void save(Student student) {
        studentRepo.save(student);
    }

    @Override
    public List<Student> getAll(String major) {
        if (major == null) {
            return studentRepo.getAll();
        }
        return studentRepo.getAllByMajor(major);
    }

    @Override
    public void updateStudentById(int id, Student student) {
        studentRepo.updateStudentById(id, student);
    }

    @Override
    public void deleteStudentById(int id) {
        studentRepo.deleteStudentById(id);
    }

    @Override
    public List<Course> getCoursesByStudentId(int studentId) {
        Student student = studentRepo.getStudentById(studentId);
        if (student == null) {
            throw new IllegalArgumentException("Student not found");
        }
        return student.getCoursesTaken();
    }
}
