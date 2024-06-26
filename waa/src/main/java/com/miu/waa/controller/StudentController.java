package com.miu.waa.controller;

import com.miu.waa.entity.Student;
import com.miu.waa.service.student.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.find(id);
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        studentService.save(student);
        return student;
    }

    @PutMapping
    public Student updateStudent(@RequestBody Student student) {
        studentService.update(student);
        return student;
    }

    @DeleteMapping
    public void delete(@RequestBody Student student) {
        studentService.delete(student);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        studentService.deleteById(id);
    }

    @GetMapping("/{major}")
    public List<Student> getStudentsByMajor(@PathVariable String major) {
        return studentService.getStudentsByMajor(major);
    }

}
