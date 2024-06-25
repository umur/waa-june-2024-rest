package miu.waa.restful.controller;

import miu.waa.restful.entity.Student;
import miu.waa.restful.service.StudentService;
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
        studentService.create(student);
    }

    @GetMapping
    public List<Student> getAll() {
        return studentService.getAll();
    }

    @GetMapping("/search")
    public List<Student> getByMajor(@RequestParam("major") String major) {
        return studentService.getStudentsByMajor(major);
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable int id) {
        return studentService.getOne(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Student student) {
        studentService.update(id, student);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        studentService.delete(id);
    }
}
