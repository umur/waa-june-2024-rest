package edu.miu.waa_june_2024_rest.repository;


import edu.miu.waa_june_2024_rest.entity.Course;
import edu.miu.waa_june_2024_rest.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author kush
 */
@Repository
public class StudentRepository {

    List<Student> studentList =new ArrayList<>();

    public Student save(Student student){
        studentList.add(student);
        return student;
    }

    public List<Student> getAll() {
        return studentList;
    }

    public Student getById(int id) {
        Optional<Student> studentOpt= studentList.stream().filter(x->x.getId()==id).findFirst();
        return studentOpt.orElse(null);
    }

    public Student update(Student student) {
        List<Student> list=studentList.stream().filter(x->x.getId()!=student.getId()).toList();
        studentList.clear();
        studentList.addAll(list);
        studentList.add(student);
        return student;
    }

    public boolean deleteById(int id) {
        studentList=studentList.stream().filter(x->x.getId()!=id).toList();
        return true;
    }

    public List<Student> getStudentsByMajor(String majorSubject) {
        return studentList.stream().filter(x->x.getMajor().equalsIgnoreCase(majorSubject)).toList();
    }

    public List<Course> getCoursesByStudentId(int id) {
        Optional<Student> studentOpt= studentList.stream().filter(x->x.getId()==id).findFirst();
        if(studentOpt.isPresent()){
            return studentOpt.get().getCoursesTaken();
        }
        return new ArrayList<>();
    }
}
