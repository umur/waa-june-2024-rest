package Lab2.controller;

import Lab2.domain.Course;
import Lab2.domain.Student;
import Lab2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getStudents(){
        return studentService.getAllStudents();
    }
    @GetMapping("/{id}")
    public Student getStudent(int id){
        return studentService.findById(id);
    }
    @PostMapping
    public void addStudent(@RequestBody Student student){
        studentService.save(student);
    }
    @DeleteMapping("/{id}")
    public void deletStudent(@PathVariable int id){
        studentService.delete(id);
    }
    @PutMapping("/{id}")
    public void updateStudent(@PathVariable int id, @RequestBody Student student){
        studentService.update(id, student);
    }
    @GetMapping("/major/{major}")
    public List<Student> getStudentByMajor(@PathVariable String major){
        return studentService.getStudentByMajor(major);
    }
    @GetMapping("/courses/{course}")
    public List<Course> getCourseByCourseId(@PathVariable int id){
       return studentService.getCoursesByStudentId(id);
    }
}
