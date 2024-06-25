package waa.lab2_restservice.repository;

import org.springframework.stereotype.Repository;
import waa.lab2_restservice.entity.Course;
import waa.lab2_restservice.entity.Student;

import java.rmi.StubNotFoundException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class StudentRepository {
    List<Student> students = new ArrayList<>();
    public void save(Student student){
        students.add(student);
    }

    public Student getById(int id){
        for(Student student:students){
            if(student.getId() == id){
                return student;
            }
        }
        return null;
    }

    public List<Student> getAll(){
        return students;
    }

    public Student updateById(int id,Student student){
        for(int i=0;i< students.size();i++){
            if(students.get(i).getId()==id){
                student.setId(id);
                students.set(i,student);
            }
        }
        return student;
    }
    public boolean deleteById(int id){
        for(int i=0;i<students.size();i++){
            if(students.get(i).getId()==id){
                students.remove(i);
                return true;
            }
        }
        return false;
    }

    public List<Student> getStudentsByMajor(String major){
        return students.stream().filter(student -> student.getMajor().equals(major)).toList();
    }

    public List<Course> getCoursesByStudentId(int studentId){
        for(Student student:students){
            if(student.getId()==studentId){
                return student.getCoursesTaken();
            }
        }
        return null;
    }
}
