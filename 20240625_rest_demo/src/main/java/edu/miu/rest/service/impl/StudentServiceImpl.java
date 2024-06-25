package edu.miu.rest.service.impl;

import edu.miu.rest.domain.Course;
import edu.miu.rest.domain.Student;
import edu.miu.rest.repository.StudentRepository;
import edu.miu.rest.service.StudentService;
import org.springframework.stereotype.Service;

import java.sql.Statement;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getStudentsByMajor(String major) {
        return studentRepository.getStudentsByMajor(major);
    }

    @Override
    public List<Course> getCoursesByStudentId(int studentId) {
        return studentRepository.getCoursesByStudentId(studentId);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.getStudents();
    }

    @Override
    public Student findById(int id) {
        return studentRepository.getStudentById(id)
                .orElseThrow(() -> new RuntimeException("Student with id: " + id + " not found")
                );
    }

    @Override
    public void save(Student student) {
        studentRepository.add(student);
    }

    @Override
    public void update(int id, Student student) {
        studentRepository.updateStudent(id, student);
    }

    @Override
    public void deleteStudentById(int id) {
        studentRepository.deleteStudentById(id);
    }
}
