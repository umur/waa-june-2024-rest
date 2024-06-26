package Lab2.controller;

import Lab2.domain.Course;
import Lab2.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;
    @GetMapping
    public List<Course> getCourses(){
        return courseService.getCourses();
    }
    @GetMapping("/{id}")
    public Course getCourse(@PathVariable int id){
        return courseService.getCourse(id);
    }
    @PostMapping
    public void addCourse(@RequestBody Course course){
        courseService.save(course);
    }
    @PutMapping
    public void updateCourse(@PathVariable int id, @RequestBody Course course){
        courseService.updateCourse(id, course);
    }

    @DeleteMapping
    public void deleteCourse(@PathVariable int id){
        courseService.deleteCourse(id);
    }
}
