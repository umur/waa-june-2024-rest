package edu.miu.cs545.lab2.repository;

import edu.miu.cs545.lab2.entity.Course;
import edu.miu.cs545.lab2.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class StudentRepo {

    private final List<Student> students = new ArrayList<>();

    public void save(Student student) {
        students.add(student);
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public Student getStudent(int id) {
        return students.stream().filter(student -> student.getId() == id).findFirst().orElse(null);
    }

    public void deleteStudent(int id) {
        students.removeIf(student -> student.getId() == id);
    }

    public void updateStudent(Student student) {
        Student studentToUpdate = students.stream().filter(s -> s.getId() == student.getId()).findFirst().orElse(null);
        if (studentToUpdate != null) {
            studentToUpdate.setFirstName(student.getFirstName());
            studentToUpdate.setLastName(student.getLastName());
            studentToUpdate.setEmail(student.getEmail());
            studentToUpdate.setMajor(student.getMajor());
            studentToUpdate.setGpa(student.getGpa());
            studentToUpdate.setCoursesTaken(student.getCoursesTaken());
        }
    }

    public List<Student> getStudentsByMajor(String major) {
        return students.stream().filter(student -> student.getMajor().equals(major)).toList();
    }

    public List<Course> getCoursesByStudentId(int studentId) {
        return Objects.requireNonNull(students.stream().filter(student -> student.getId() == studentId).findFirst().map(Student::getCoursesTaken).orElse(null));
    }
}
