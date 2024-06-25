package edu.miu.waa_june_2024_rest.controller;

import edu.miu.waa_june_2024_rest.entity.Course;
import edu.miu.waa_june_2024_rest.entity.Student;
import edu.miu.waa_june_2024_rest.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author kush
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public List<Student> getAll(){
        return studentService.getAll();
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable int id){
        return studentService.getById(id);
    }

    @PostMapping
    public Student save(@RequestBody Student student){
        return studentService.save(student);
    }

    @PutMapping("/{id}")
    public Student update(@RequestBody Student student,@PathVariable int id){
        return studentService.update(id,student);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable int id){
        return studentService.delete(id);
    }

    @GetMapping("/major/{majorSubject}")
    public List<Student> getStudentsByMajor(@PathVariable String majorSubject){
        return studentService.getStudentsByMajor(majorSubject);
    }

    @GetMapping("/{id}/courses")
    public List<Course> getCoursesByStudentId(@PathVariable int id){
        return studentService.getCoursesByStudentId(id);
    }
}
