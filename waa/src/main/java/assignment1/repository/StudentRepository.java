package assignment1.repository;

import assignment1.domain.Course;
import org.springframework.stereotype.Repository;
import assignment1.domain.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {
    private List<Student> students=new ArrayList<>();
    public List<Student> getStudents() {
        return students;
    }
    public List<Student> findAll(){
        return students;
    }
    public Student get(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }
    public Student save(Student student) {
        students.add(student);
        return student;
    }

    public Student update(Student student) {
        int index = -1;
        for(int i=0;i<students.size();i++) {
            if(students.get(i).getId()==student.getId()) {
                index = i;
            }
        }
        if (index != -1) {
            students.set(index, student);
        }
        return student;
    }
    public void delete(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                students.remove(student);
            }
        }
    }
    public List<Student> findByMajor(String major){
        return students.stream().filter(a->a.getMajor().equals(major))
                .collect(Collectors.toList());
    }
    public List<Course> getStudentCourses(int studentId){
        Student student =  students.stream().filter(a->a.getId()==studentId)
                .findAny().get();
        return student.getCoursesTaken();
    }
}
