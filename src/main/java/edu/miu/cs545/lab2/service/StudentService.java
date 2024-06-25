package edu.miu.cs545.lab2.service;

import edu.miu.cs545.lab2.entity.Course;
import edu.miu.cs545.lab2.entity.Student;
import edu.miu.cs545.lab2.repository.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepo studentRepo;

    public void save(Student student) {
        studentRepo.save(student);
    }

    public void deleteStudent(int id) {
        studentRepo.deleteStudent(id);
    }

    public void updateStudent(Student student) {
        studentRepo.updateStudent(student);
    }

    public Student getStudent(int id) {
        return studentRepo.getStudent(id);
    }

    public List<Student> getAllStudents() {
        return studentRepo.getAllStudents();
    }

    public List<Student> getStudentsByMajor(String major) {
        return studentRepo.getStudentsByMajor(major);
    }

    public List<Course> getCoursesByStudentId(int studentId) {
        return studentRepo.getCoursesByStudentId(studentId);
    }
}
