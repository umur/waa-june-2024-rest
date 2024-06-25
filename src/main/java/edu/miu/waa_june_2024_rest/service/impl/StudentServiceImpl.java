package edu.miu.waa_june_2024_rest.service.impl;

import edu.miu.waa_june_2024_rest.entity.Course;
import edu.miu.waa_june_2024_rest.entity.Student;
import edu.miu.waa_june_2024_rest.repository.StudentRepository;
import edu.miu.waa_june_2024_rest.service.CourseService;
import edu.miu.waa_june_2024_rest.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author kush
 */
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final CourseService courseService;


    @Override
    public List<Student> getAll() {
        return studentRepository.getAll();
    }

    @Override
    public Student getById(int id) {
        Student student= studentRepository.getById(id);
        if(Objects.isNull(student)){
            throw new RuntimeException("No student Found");
        }
        return student;
    }

    @Override
    public Student save(Student student) {
        if(student.getId()<1){
            throw new RuntimeException("Ids cant be less than 1");
        }
        Student existingCourse=studentRepository.getById(student.getId());
        if(Objects.nonNull(existingCourse)){
            throw new RuntimeException("Course exists already");
        }
        List<Course> courses=courseService.getByIds(student.getCoursesTaken().stream().map(Course::getId).toList());
        if(courses.size()!=student.getCoursesTaken().size()){
            throw new RuntimeException("Invalid course id/s");
        }
        return studentRepository.save(student);
    }

    @Override
    public Student update(int id, Student student) {
        if(id!=student.getId()){
            throw new RuntimeException("Invalid student supplied");
        }
        Student existingStudent=studentRepository.getById(student.getId());
        if(Objects.isNull(existingStudent)){
            throw new RuntimeException("No such student exists");
        }
        List<Course> courses=courseService.getByIds(student.getCoursesTaken().stream().map(Course::getId).toList());
        if(courses.size()!=student.getCoursesTaken().size()){
            throw new RuntimeException("Invalid course id/s");
        }
        return studentRepository.update(student);
    }

    @Override
    public boolean delete(int id) {
        Student student= studentRepository.getById(id);
        if(Objects.isNull(student)){
            throw new RuntimeException("No student Found");
        }
        return studentRepository.deleteById(id);
    }

    @Override
    public List<Student> getStudentsByMajor(String majorSubject) {
        return studentRepository.getStudentsByMajor(majorSubject);
    }

    @Override
    public List<Course> getCoursesByStudentId(int id) {
        return studentRepository.getCoursesByStudentId(id);
    }

}
