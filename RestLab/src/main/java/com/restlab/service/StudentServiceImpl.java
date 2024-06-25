package com.restlab.service;

import com.restlab.entity.Course;
import com.restlab.entity.Student;
import com.restlab.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentRepository studentRepository;
    @Override
    public void createStudent(Student student) {
        studentRepository.createStudent(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    @Override
    public Student getStudentById(int id) {
        return studentRepository.getAllStudentById(id);
    }

    @Override
    public Student updateStudentById(int id, Student student) {
        return studentRepository.updateStudent(id,student);
    }

    @Override
    public void deleteStudent(int id) {
        studentRepository.deleteStudentById(id);
    }

    @Override
    public List<Student> getStudentsByMajor(String major) {
        return studentRepository.getStudentsByMajor(major);
    }

    @Override
    public List<Course> getCoursesByStudentId(int studentId) {
        return studentRepository.getCoursesByStudentId(studentId);
    }
}
