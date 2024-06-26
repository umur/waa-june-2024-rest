package com.miu.waa.service.student;

import com.miu.waa.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> findAll();
    Student find(Long id);
    void save(Student student);
    void update(Student student);
    void delete(Student student);
    void deleteById(Long id);
    List<Student> getStudentsByMajor(String major);

}
