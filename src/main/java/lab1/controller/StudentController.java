package lab1.controller;

import lab1.entity.Course;
import lab1.entity.Student;
import lab1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public void save(@RequestBody Student student) {
        studentService.save(student);
    }

    @GetMapping
    public List<Student> getAll() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable int id) {
        return studentService.getStudent(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id,@RequestBody Student student) {
        studentService.updateStudent(id,student);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        studentService.deleteStudent(id);
    }

    @GetMapping("/filter")
    public List<Student> filter(@RequestParam String major) {
        return studentService.getStudentsByMajor(major);
    }

    @GetMapping("/courses/{id}")
    public List<Course> filter(@PathVariable int id) {
        return studentService.getCoursesByStudentId(id);
    }
}
