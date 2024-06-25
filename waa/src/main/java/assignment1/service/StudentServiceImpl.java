package assignment1.service;


import assignment1.domain.Course;
import org.springframework.stereotype.Service;
import assignment1.domain.Student;
import assignment1.repository.StudentRepository;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAll() {
        return studentRepository.findAll();
    }
    public Student getById(int id){
        return studentRepository.get(id);
    }
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void update(Student student) {
        studentRepository.update(student);
    }

    @Override
    public void delete(int id) {
        studentRepository.delete(id);
    }

    @Override
    public List<Student> findByMajor(String major) {
        return studentRepository.findByMajor(major);
    }
    @Override
    public List<Course> getStudentCourses(int studentId) {
        return studentRepository.getStudentCourses(studentId);
    }
}
