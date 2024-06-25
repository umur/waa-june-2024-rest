package waa.lab2_restservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import waa.lab2_restservice.entity.Course;
import waa.lab2_restservice.entity.Student;
import waa.lab2_restservice.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping
    public void save(@RequestBody Student student){
        studentService.save(student);
    }

    @GetMapping
    public List<Student> getAll(){
        return studentService.getAll();
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable int id){
        
        return studentService.getById(id);
    }

    @PutMapping("/{id}")
    public Student updateStudentById(@PathVariable int id,@RequestBody Student student){
        return studentService.updateById(id,student);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){
        studentService.deleteById(id);
    }

    @GetMapping("/filter")
    public List<Student> getStudentByMajor(@RequestParam String major){
        return studentService.getStudentsByMajor(major);
    }

    @GetMapping("/courses")
    public List<Course> getCoursesByStudentId(int studentId){
        return studentService.getCoursesByStudentId(studentId);
    }
}
