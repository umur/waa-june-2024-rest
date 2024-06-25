package miu.waa.lab2.service;

import miu.waa.lab2.entity.Course;
import miu.waa.lab2.entity.Student;

import java.util.List;

public interface StudentService {
    Boolean create(Student student);
    List<Student> getAll();
    Student getStudentById(Long id);
    Student update(Long id, Student studentDetails);
    boolean deleteStudentById(Long id);
    List<Student> getStudentsByMajor(String major);
    List<Course> getCoursesByStudentId(Long studentId);
}
