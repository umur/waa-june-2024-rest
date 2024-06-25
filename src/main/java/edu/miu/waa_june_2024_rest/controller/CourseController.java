package edu.miu.waa_june_2024_rest.controller;

import edu.miu.waa_june_2024_rest.entity.Course;
import edu.miu.waa_june_2024_rest.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author kush
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public List<Course> getAll(){
        return courseService.getAll();
    }

    @GetMapping("/{id}")
    public Course getById(@PathVariable int id){
        return courseService.getById(id);
    }

    @PostMapping
    public Course save(@RequestBody Course course){
        return courseService.save(course);
    }

    @PutMapping("/{id}")
    public Course update(@RequestBody Course course,@PathVariable int id){
        return courseService.update(id,course);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable int id){
        return courseService.delete(id);
    }
}
