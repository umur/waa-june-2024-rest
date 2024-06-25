package miu.waa.lab2.controller;

import lombok.RequiredArgsConstructor;
import miu.waa.lab2.entity.Course;
import miu.waa.lab2.entity.Student;
import miu.waa.lab2.service.impl.StudentServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {
    private final StudentServiceImpl studentService;

    @PostMapping
    public ResponseEntity<Student> create(@RequestBody Student student) {
        if (studentService.create(student)) {
            return new ResponseEntity<>(student, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(student, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<Student>> getStudentsByMajor(@RequestParam(required = false) String major) {
        List<Student> students;
        if (major != null) {
            students = studentService.getStudentsByMajor(major);
        } else {
            students = studentService.getAll();
        }
        return ResponseEntity.ok(students);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Student student = studentService.getStudentById(id);
        if (student == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(student, HttpStatus.OK);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> update(@PathVariable Long id, @RequestBody Student student) {
        Student updated = studentService.update(id, student);
        if (updated == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        boolean deleted = studentService.deleteStudentById(id);
        if (deleted) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}/courses")
    public ResponseEntity<List<Course>> getCoursesByStudentId(@PathVariable Long id) {
        List<Course> courses = studentService.getCoursesByStudentId(id);
        if (courses == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(courses, HttpStatus.OK);
        }
    }
}