package cs544.lab2.controller;

import cs544.lab2.entity.*;
import cs544.lab2.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
@AllArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping("/students")
    public void addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
    }
    @DeleteMapping("/students/{studentId}")
    public void deleteStudent(@RequestParam long studentId) {
        studentService.deleteStudent(studentId);
    }

    @PutMapping("/students")
    public void updateStudent(@RequestBody Student student) {
        studentService.updateStudent(student);
    }
    @GetMapping("/students/{studentId}")
    public Student getStudent(long studentId) {
        return studentService.getStudent(studentId);
    }

    @GetMapping("/students/major/{major}")
    public List<Student> getStudentsByMajor(String major) {
        return studentService.getStudentsByMajor(major);
    }

    @GetMapping("/students/{studentId}/courses")
    public List<Course> getCoursesByStudentId(long studentid) {
        return studentService.getCoursesByStudentId(studentid);
    }

}
