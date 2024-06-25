package assignment1.controller;

import assignment1.domain.Course;
import assignment1.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import assignment1.domain.Student;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getAll() {
        return studentService.getAll();
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable int id) {
        return studentService.getById(id);
    }

    @PostMapping
    public void save(@RequestBody Student student){
        studentService.save(student);
    }
    @PutMapping
    public void update(@RequestBody Student student){
        studentService.update(student);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        studentService.delete(id);
    }

    @GetMapping("/major/{major}")
    public List<Student> getByMajor(@PathVariable String major) {
        return studentService.findByMajor(major);
    }

    @GetMapping("/{id}/courses")
    public List<Course> getStudentCourses(@PathVariable int id) {
        return studentService.getStudentCourses(id);
    }
}
