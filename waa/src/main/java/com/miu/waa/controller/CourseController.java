package com.miu.waa.controller;

import com.miu.waa.entity.Course;
import com.miu.waa.service.course.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public List<Course> list() {
        return courseService.findAll();
    }

    @GetMapping("/{id}")
    public Course get(@PathVariable Long id) {
        return courseService.find(id);
    }

    @PostMapping
    public Course create(@RequestBody Course course) {
        courseService.save(course);
        return course;
    }

    @PutMapping
    public Course update(@RequestBody Course course) {
        courseService.update(course);
        return course;
    }

    @DeleteMapping
    public void delete(@RequestBody Course course) {
        courseService.delete(course);
    }

}
