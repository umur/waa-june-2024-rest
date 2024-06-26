package com.example.course_management_system.repository.impl;
import com.example.course_management_system.entity.Student;
import com.example.course_management_system.repository.StudentRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class StudentRepositoryImpl implements StudentRepository {
    private final List<Student> students = new ArrayList<>();

    @Override
    public List<Student> findAll() {
        return students;
    }

    @Override
    public Student findById(int id) {
        return students.stream().filter(student -> student.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void save(Student student) {
        students.add(student);
    }

    @Override
    public void update(int id, Student student) {
        Optional<Student> existingStudent = students.stream().filter(s -> s.getId() == id).findFirst();
        existingStudent.ifPresent(s -> {
            s.setFirstName(student.getFirstName());
            s.setLastName(student.getLastName());
            s.setEmail(student.getEmail());
            s.setMajor(student.getMajor());
            s.setGpa(student.getGpa());
            s.setCourseIds(student.getCourseIds());
        });
    }

    @Override
    public void deleteById(int id) {
        students.removeIf(student -> student.getId() == id);
    }
    @Override
    public List<Student> findByMajor(String major) {
        return students.stream()
                .filter(student -> student.getMajor().equalsIgnoreCase(major))
                .collect(Collectors.toList());
    }
}
