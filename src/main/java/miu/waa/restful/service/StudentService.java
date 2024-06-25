package miu.waa.restful.service;

import miu.waa.restful.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAll();
    Student getOne(int id);
    List<Student> getStudentsByMajor(String major);
    
    Student create(Student student);
    void update(int id, Student student);
    void delete(int id);
}
