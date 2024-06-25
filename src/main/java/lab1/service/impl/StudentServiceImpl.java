package lab1.service.impl;

import lab1.entity.Course;
import lab1.entity.Student;
import lab1.repository.StudentRepository;
import lab1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public void save(Student student) {
        if(student == null || student.getFirstName().isEmpty()){
            throw new RuntimeException("Course name cannot be empty");
        }
        studentRepository.save(student);
    }

    @Override
    public Student getStudent(int id) {
        Student result=studentRepository.findById(id);

        if(result==null || result.getFirstName().isEmpty()){
            throw new RuntimeException("Course name cannot be found");
        }
        return result;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public void deleteStudent(int id) {
        boolean result=studentRepository.deleteById(id);

        if(!result){
            throw new RuntimeException("Student cannot be found");
        }
    }

    @Override
    public void updateStudent(int id, Student student) {
        studentRepository.update(id,student);
    }

    @Override
    public List<Student> getStudentsByMajor(String major) {
        return studentRepository.getByMajor(major);
    }

    @Override
    public List<Course> getCoursesByStudentId(int id) {
        return studentRepository.getCoursesByStudentId(id);
    }
}
