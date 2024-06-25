package lab1.controller;

import lab1.entity.Course;
import lab1.service.CourseService;
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
        courseService.save(course);
    }

    @GetMapping
    public List<Course> getAll() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public Course getById(@PathVariable int id) {
        return courseService.getCourse(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id,@RequestBody Course course) {
        courseService.updateCourse(id,course);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        courseService.deleteCourse(id);
    }

}
