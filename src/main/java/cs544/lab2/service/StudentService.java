package cs544.lab2.service;

import cs544.lab2.entity.*;
import cs544.lab2.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public void addStudent(Student student) {
        studentRepository.add(student);
    }
    public void deleteStudent(long studentid) {
        studentRepository.delete(studentid);
    }
    public void updateStudent(Student student) {
        studentRepository.update(student);
    }
    public Student getStudent(long studentid) {
        return studentRepository.get(studentid);
    }

    public List<Student> getStudentsByMajor(String major) {
        return studentRepository.getAll().stream()
                .filter(student -> student.getMajor().equals(major))
                .toList();
    }

    public List<Course> getCoursesByStudentId(long studentid) {
        return studentRepository.get(studentid).getCourses();
    }
}
