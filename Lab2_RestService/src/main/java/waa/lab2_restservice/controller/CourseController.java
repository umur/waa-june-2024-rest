package waa.lab2_restservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import waa.lab2_restservice.entity.Course;
import waa.lab2_restservice.entity.Student;
import waa.lab2_restservice.service.CourseService;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping
    public void save(@RequestBody Course course){
        courseService.save(course);
    }

    @GetMapping
    public List<Course> getAll(){
        return courseService.getAll();
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable int id){
        return courseService.getById(id);
    }

    @PutMapping("/{id}")
    public Course updateCourseById(@PathVariable int id,@RequestBody Course course){
        return courseService.updateById(id,course);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){
        courseService.deleteById(id);
    }
}
