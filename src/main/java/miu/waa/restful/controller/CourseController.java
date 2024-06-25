package miu.waa.restful.controller;

import miu.waa.restful.entity.Course;
import miu.waa.restful.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping
    public void save(@RequestBody Course course) {
        courseService.create(course);
    }

    @GetMapping
    public List<Course> getAll() {
        return courseService.getAll();
    }

    @GetMapping("/search")
    public List<Course> getByStudentId(@RequestParam("studentId") int studentId) {
        return courseService.getCoursesByStudentId(studentId);
    }

    @GetMapping("/{id}")
    public Course getById(@PathVariable int id) {
        return courseService.getOne(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Course course) {
        courseService.update(id, course);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        courseService.delete(id);
    }
}
