package restapi.service.student;

import restapi.domain.Course;
import restapi.domain.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();

    List<Student> getStudentsByMajor(String major);

    Student findById(Integer id);

    List<Course> getCoursesByStudentId(Integer studentId);

    void create(Student student);

    void update(Student student);

    void deleteById(Integer id);
}
