package miu.waa.lab2.service.impl;

import lombok.RequiredArgsConstructor;
import miu.waa.lab2.entity.Course;
import miu.waa.lab2.entity.Student;
import miu.waa.lab2.repository.StudentRepository;
import miu.waa.lab2.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Override
    public Boolean create(Student student) {
        return studentRepository.create(student);
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.getAllStudents();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.getStudentById(id);
    }

    @Override
    public Student update(Long id, Student studentDetails) {
        return studentRepository.update(id, studentDetails);
    }

    @Override
    public boolean deleteStudentById(Long id) {
        return studentRepository.deleteStudentById(id);
    }

    @Override
    public List<Student> getStudentsByMajor(String major) {
        return studentRepository.getStudentsByMajor(major);
    }

    @Override
    public List<Course> getCoursesByStudentId(Long studentId) {
        return studentRepository.getCoursesByStudentId(studentId);
    }
}