package com.restlab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.restlab.entity.Student;
import com.restlab.service.StudentService;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public void createStudent(@RequestBody Student student){
        studentService.createStudent(student);
    }

    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id){
        return studentService.getStudentById(id);
    }

    @PutMapping("/{id}")
    public Student updateStudentById(@PathVariable int id,@RequestBody Student student){
        return studentService.updateStudentById(id,student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable int id){
        studentService.deleteStudent(id);
    }
}
