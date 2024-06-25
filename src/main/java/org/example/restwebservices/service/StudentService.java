package org.example.restwebservices.service;

import com.example.earest.model.Course;
import com.example.earest.model.Student;
import com.example.earest.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student createStudent(Student student) {
        return studentRepository.create(student);
    }

    public Optional<Student> getStudentById(int id) {
        return studentRepository.findById(id);
    }

    public Optional<Student> updateStudent(int id, Student student) {
        return studentRepository.update(id, student);
    }

    public void deleteStudent(int id) {
        studentRepository.delete(id);
    }

    public List<Student> getStudentsByMajor(String major) {
        return studentRepository.findByMajor(major);
    }

    public List<Course> getCoursesByStudentId(int studentId) {
        Optional<Student> opt = studentRepository.findById(studentId);

        if (opt.isPresent()) {
            return opt.get().getCoursesTaken();
        } else {
            return Collections.emptyList();
        }
    }


}
