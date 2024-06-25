package waa.lab2_restservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import waa.lab2_restservice.entity.Course;
import waa.lab2_restservice.entity.Student;
import waa.lab2_restservice.repository.StudentRepository;

import java.util.List;
@Repository
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{
    final StudentRepository studentRepository;
    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Student getById(int id) {
        Student student = studentRepository.getById(id);
        if(student == null){
            throw new RuntimeException("Student not found with id:"+id);
        }
        return student;
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.getAll();
    }

    @Override
    public Student updateById(int id, Student student) {
        Student stu = studentRepository.updateById(id,student);
        if(stu==null){
            throw new RuntimeException("Student not found with id:"+id);
        }else{
            return stu;
        }
    }

    @Override
    public void deleteById(int id) {
        if(!studentRepository.deleteById(id)){
            throw new RuntimeException("Student not found with id:"+id);
        }
    }

    @Override
    public List<Student> getStudentsByMajor(String major) {
        return studentRepository.getStudentsByMajor(major);
    }

    @Override
    public List<Course> getCoursesByStudentId(int studentId) {
        return studentRepository.getCoursesByStudentId(studentId);
    }
}
