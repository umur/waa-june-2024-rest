package cs544.lab2.repository;

import cs544.lab2.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {
    private static List<Student> students = new ArrayList<>();
    public void add(Student student) {
        students.add(student);
    }
    public List<Student> getAll() {
        return students;
    }
    public Student get(long studentid) {
        for (Student student : students) {
            if (student.getId() == studentid) {
                return student;
            }
        }
        return null;
    }
    public void delete(long studentid) {
        students.removeIf(student -> student.getId() == studentid);
    }
    public void update(Student student) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == student.getId()) {
                students.set(i, student);
                return;
            }
        }
    }

}
