package Lab2.service;

import Lab2.domain.Course;
import Lab2.domain.Student;
import Lab2.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudnetServiceImpl implements  StudentService{

    @Autowired
    private StudentRepo studentRepo;


    public void save(Student student){
        studentRepo.save(student);
    }
    public void delete(int id){
        Student student = studentRepo.findById(id);
        if(student == null){
            throw new RuntimeException("Student not found");
        }
        studentRepo.deleteById(id);
    }
    public Student findById(int id){
        Student student = studentRepo.findById(id);
        if(student == null){
            throw new RuntimeException("Student not found");
        }
        return studentRepo.findById(id);
    }
    public void update(int id, Student student){
        Student student1 = studentRepo.findById(id);
        if(student1 == null){
            throw new RuntimeException("Student not found");
        }

        studentRepo.updateById(id,student);
    }

    public List<Student> getStudentByMajor(String major){
       return studentRepo.getByMajor(major);
    }
    public List<Course> getCoursesByStudentId(int id){
        return studentRepo.getCourseByStudentId(id);
    }
    public List<Student> getAllStudents(){
        return studentRepo.getAll();
    }
}
