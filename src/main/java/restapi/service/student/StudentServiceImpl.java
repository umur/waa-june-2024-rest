package restapi.service.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import restapi.domain.Course;
import restapi.domain.Student;
import restapi.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> getStudentsByMajor(String major) {
        return studentRepository.findByMajor(major);
    }

    @Override
    public Student findById(Integer id) {
        return studentRepository.findById(id);
    }

    @Override
    public List<Course> getCoursesByStudentId(Integer studentId) {
        Student student = studentRepository.findById(studentId);
        if(!Objects.isNull(student)) {
            return student.getCoursesTaken().stream().toList();
        }
        return new ArrayList<>();
    }

    @Override
    public void create(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void update(Student student) {
        studentRepository.deleteById(student.getId());
        studentRepository.save(student);
    }

    @Override
    public void deleteById(Integer id) {
        studentRepository.deleteById(id);
    }
}
