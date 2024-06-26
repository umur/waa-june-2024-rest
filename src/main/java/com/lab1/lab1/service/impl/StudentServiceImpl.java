package com.lab1.lab1.service.impl;

import com.lab1.lab1.entity.Course;
import com.lab1.lab1.entity.Student;
import com.lab1.lab1.repository.StudentRepository;
import com.lab1.lab1.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl  implements StudentService {

    private final StudentRepository studentRepository;
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    @Override
    public void addStudent(Student student) {
        studentRepository.save(student);

    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(int id) {
        return studentRepository.findById(id);
    }

    @Override
    public void deleteStudentById(int id) {
        studentRepository.deleteById(id);

    }
    @Override
    public Student updateStudent(Student student) {
        return studentRepository.update(student);

    }
    @Override
    public List<Student> getStudentsByMajor(String major) {
        return studentRepository.findByMajor(major);
    }

    @Override
    public List<Course> getCoursesByStudentId(int studentId) {
        return studentRepository.findById(studentId).getCoursesTaken();
    }

}
