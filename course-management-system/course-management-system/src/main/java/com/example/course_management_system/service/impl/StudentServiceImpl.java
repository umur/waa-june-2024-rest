package com.example.course_management_system.service.impl;
import com.example.course_management_system.entity.Course;
import com.example.course_management_system.entity.Student;
import com.example.course_management_system.repository.CourseRepository;
import com.example.course_management_system.repository.StudentRepository;
import com.example.course_management_system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private  final CourseRepository courseRepository;
    @Autowired
    public  StudentServiceImpl(StudentRepository studentRepository,CourseRepository courseRepository){
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
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
    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void updateStudent(int id, Student student) {
        studentRepository.update(id, student);
    }

    @Override
    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> getStudentsByMajor(String major) {
       return  studentRepository.findByMajor(major);
    }

    @Override
    public List<Course> getCoursesByStudentId(int studentId) {
        Student student = studentRepository.findById(studentId);
        if (student == null) {
            return new ArrayList<>();
        }
        return student.getCourseIds().stream()
                .map(courseRepository::findById)
                .collect(Collectors.toList());
    }
}
