package org.example.restwebservices.repository;

import org.example.restwebservices.model.Student;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {
    private static final List<Student> students = new ArrayList<>();
    private static final AtomicInteger idGenerator = new AtomicInteger();

    public List<Student> findAll() {
        return students;
    }

    public Student create(Student student) {
        student.setId(idGenerator.incrementAndGet());
        students.add(student);
        return  student;
    }

    public Optional<Student> findById(int id) {
        return students.stream()
                .filter(student -> student.getId() == id)
                .findFirst();
    }

    public Optional<Student> update(int id, Student updatedStudent) {
        return findById(id).map(student -> {
            student.setFirstName(updatedStudent.getFirstName());
            student.setLastName(updatedStudent.getLastName());
            student.setEmail(updatedStudent.getEmail());
            student.setMajor(updatedStudent.getMajor());
            student.setGpa(updatedStudent.getGpa());
            student.setCoursesTaken(updatedStudent.getCoursesTaken());

            return student;
        });
    }

    public void delete(int id) {
        students.removeIf(student -> student.getId() == id);
    }

    public List<Student> findByMajor(String major) {
        return students.stream().filter(student -> major.equals(student.getMajor())).collect(Collectors.toList());
    }
}
