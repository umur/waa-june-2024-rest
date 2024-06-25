package com.lab1.lab1.controller;

import com.lab1.lab1.entity.Course;
import com.lab1.lab1.entity.Student;
import com.lab1.lab1.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id) {
        Student student = studentService.getStudentById(id);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @PostMapping
    public void  addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student student) {
        Student stud = studentService.getStudentById(id);
        if (stud != null) {
            stud.setFirstName(student.getFirstName());
            stud.setLastName(student.getLastName());
            stud.setEmail(student.getEmail());
            stud.setMajor(student.getMajor());
            stud.setGpa(student.getGpa());
            stud.setCoursesTaken(student.getCoursesTaken());
            return ResponseEntity.ok(studentService.updateStudent(stud));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>  deleteStudent(@PathVariable int id) {
        Student student = studentService.getStudentById(id);
        if (student != null) {
            studentService.deleteStudentById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/filter")
    public List<Student> getStudentsByMajor(@RequestParam String major) {
        return studentService.getStudentsByMajor(major);
    }

    @GetMapping("/{id}/courses")
    public ResponseEntity<List<Course>> getStudentsByCourse(@PathVariable int id) {
        Student student = studentService.getStudentById(id);
        if (student != null) {
            return ResponseEntity.ok(studentService.getCoursesByStudentId(id));
        }
        return ResponseEntity.notFound().build();
    }
}
