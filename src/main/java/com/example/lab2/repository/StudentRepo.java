package com.example.lab2.repository;

import com.example.lab2.entity.Student;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Getter
@Setter
public class StudentRepo {
    private final List<Student> students = new ArrayList<>();

    public void save(Student student) {
        students.add(student);
    }

    public List<Student> getAll() {
        return students;
    }

    public List<Student> getAllByMajor(String major) {
        List<Student> studentsByMajor = new ArrayList<>();
        for (Student student : students) {
            if (student.getMajor().equals(major)) {
                studentsByMajor.add(student);
            }
        }
        return studentsByMajor;
    }

    public Student getStudentById(int studentId) {
        for (Student student : students) {
            if (student.getId() == studentId) {
                return student;
            }
        }
        return null;
    }

    public void deleteStudentById(int id) {
        Student student = getStudentById(id);
        if (student != null) {
            students.remove(student);
        }
    }

    public void updateStudentById(int id, Student student) {
        Student studentToUpdate = getStudentById(id);
        if (studentToUpdate != null) {
            studentToUpdate.setMajor(student.getMajor());
            studentToUpdate.setGpa(student.getGpa());
            studentToUpdate.setEmail(student.getEmail());
            studentToUpdate.setFirstName(student.getFirstName());
            studentToUpdate.setLastName(student.getLastName());
            studentToUpdate.setCoursesTaken(student.getCoursesTaken());
        }
    }
}
