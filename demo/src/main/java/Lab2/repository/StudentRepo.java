package Lab2.repository;

import Lab2.domain.Course;
import Lab2.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {

    List<Student> students = new ArrayList<Student>();

    public void save(Student student){
        students.add(student);
    }
    public List<Student> findAll(){
        return students;
    }
    public Student findById(int id){
        return students.get(id);
    }
    public void deleteById(int id){
        Student student = students.get(id);
        students.remove(student);
    }
    public void updateById(int id, Student student){
        students.set(id, student);
    }
    public List<Student> getByMajor(String major){
        List<Student> studentByMajor = new ArrayList<>();
        for(Student student : students){
            if(student.getMajor().equals(major)){
                studentByMajor.add(student);
            }
        }
        return studentByMajor;
    }
    public List<Course> getCourseByStudentId(int id){
        Student student = students.get(id);
        return student.getCourses();
    }
}
