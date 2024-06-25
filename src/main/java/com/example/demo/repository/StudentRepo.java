package com.example.demo.repository;

import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class StudentRepo {
    static List<Student> students = new ArrayList<>(Arrays.asList(
            new Student(1, "Dinh Trung", "Tran", "trung@gmail.com", "Computer Science", 10, new ArrayList<>(
                    Arrays.asList(CourseRepo.courses.get(0))
            ))
    ));
    public Student getStudentById(long id) {
        return students.stream()
                .filter(student -> student.getId() == id)
                .findFirst()
                .orElse(null);
    }
    public List<Student> getAll() {
        return students;
    }
    public void createStudent(Student student) {
        students.add(student);
    }
    public void updateStudent(Student student) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == student.getId()) {
                students.set(i, student);
                break;
            }
        }
    }
    public void deleteStudent(long id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                students.remove(i);
                break;
            }
        }
    }

    public List<Student> getStudentsByMajor(String major) {
        return students.stream()
                .filter(student -> student.getMajor().equals(major))
                .toList();
    }
    public List<Course> getCoursesByStudentId(long studentId) {
        for (Student student : students) {
            if (student.getId() == studentId) {
                return student.getCoursesTaken();
            }
        }
        return new ArrayList<>();
    }
}
