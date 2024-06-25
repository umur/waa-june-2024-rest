package cs545.lab.lab02.service.Impl;

import cs545.lab.lab02.domain.Student;
import cs545.lab.lab02.repository.StudentRepo;
import cs545.lab.lab02.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;

    @Override
    public Student addStudent(Student student) {
        return studentRepo.saveStudent(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepo.getAllStudents();
    }

    @Override
    public Student getStudentById(int id) {
        return studentRepo.getStudent(id);
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepo.saveStudent(student);
    }

    @Override
    public void deleteStudent(int id) {
        studentRepo.deleteStudent(id);
    }

    @Override
    public List<Student> getStudentsByMajor(String major) {
        return studentRepo.getStudentsByMajor(major);
    }
}
