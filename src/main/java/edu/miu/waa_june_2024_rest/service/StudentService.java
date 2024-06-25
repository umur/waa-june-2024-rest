package edu.miu.waa_june_2024_rest.service;

import edu.miu.waa_june_2024_rest.entity.Course;
import edu.miu.waa_june_2024_rest.entity.Student;
import edu.miu.waa_june_2024_rest.entity.Student;

import java.util.List;

/**
 * @author kush
 */
public interface StudentService {
    List<Student> getAll();

    Student getById(int id);

    Student save(Student Student);

    Student update(int id, Student Student);

    boolean delete(int id);

    List<Student> getStudentsByMajor(String majorSubject);

    List<Course> getCoursesByStudentId(int id);
}
