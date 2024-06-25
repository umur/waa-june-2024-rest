package lab1.service;

import lab1.entity.Course;
import lab1.entity.Student;

import java.util.List;

public interface StudentService {

    public void save(Student student);
    public Student getStudent(int id);
    public List<Student> getAllStudents();
    public void deleteStudent(int id);
    public void updateStudent(int id,Student student);
    public List<Student> getStudentsByMajor(String major);
    public List<Course> getCoursesByStudentId(int id);
}
