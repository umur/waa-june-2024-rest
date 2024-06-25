package com.example.lab2.controller;

import com.example.lab2.entity.Course;
import com.example.lab2.service.CourseService;
import com.example.lab2.service.impl.CourseServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("courses")
public class CourseController {
    private CourseService courseService;

    @GetMapping
    public List<Course> getCourse() {
        return courseService.getAll();
    }

    @PostMapping("/")
    public void saveCourse(@RequestBody Course course) {
        courseService.save(course);
    }

    @PutMapping("/{id}")
    public void updateCourse(@PathVariable int id, @RequestBody Course course) {
        courseService.updateCourseById(id, course);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable int id) {
        courseService.deleteCourseById(id);
    }
}
