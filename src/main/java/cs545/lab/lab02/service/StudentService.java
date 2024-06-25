package cs545.lab.lab02.service;

import cs545.lab.lab02.domain.Student;

import java.util.List;

public interface StudentService {

    Student addStudent(Student student);

    List<Student> getAllStudents();

    Student getStudentById(int id);

    Student updateStudent(Student student);

    void deleteStudent(int id);

    List<Student> getStudentsByMajor(String major);


}
