package com.lab1.lab1.repository;

import com.lab1.lab1.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {
    private final List<Student> students = new ArrayList<>();

    public List<Student> findAll() {
        return students;
    }

    public void save(Student student) {
        students.add(student);
    }
    public Student findById(int id) {
        return students.stream().filter(student -> student.getId() == id).findFirst().orElse(null);
    }

    public Student update(Student student) {
        students.replaceAll(s -> s.getId() == student.getId() ? student : s);
        return student;
    }

   public void deleteById(int id) {
        students.removeIf(student -> student.getId() == id);
   }
    public List<Student> findByMajor(String major) {
        return students.stream().filter(s -> s.getMajor().equals(major)).toList();

    }

}
