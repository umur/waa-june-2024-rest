package com.restlab.repository;

import com.restlab.entity.Course;
import com.restlab.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {

    private final List<Student> students = new ArrayList<>();

    public void createStudent(Student student){
        students.add(student);
    }

    public List<Student> getAllStudents(){
        return students;
    }

    public Student getAllStudentById(int id){
        return students.stream()
                .filter(s -> s.getId() == id)
                .findFirst().orElse(null);
    }

    public Student updateStudent(int id,Student student){
        for(int i=0; i < students.size(); i++){
            if(students.get(i).getId() == id){
                students.set(i, student);
                return student;
            }
        }
        return null;
    }

    public void deleteStudentById(int id){
        students.removeIf(s -> s.getId() == id);
    }

    public List<Student> getStudentsByMajor(String major){
        return students.stream()
                .filter(s -> s.getMajor().equals(major))
                .collect(Collectors.toList());
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
