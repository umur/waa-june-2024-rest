package com.restlab.controller;

import com.restlab.entity.Course;
import com.restlab.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping
    public void createCourse(@RequestBody Course course){
        courseService.createCourse(course);
    }

    @GetMapping
    public List<Course> getAllCourses(){
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable int id){
        return courseService.getCourseById(id);
    }

    @PutMapping("/{id}")
    public Course updateCourseById(@PathVariable int id,@RequestBody Course course){
        return courseService.updateCourse(id,course);
    }

    @DeleteMapping("/{id}")
    public void deleteCourseById(@PathVariable int id){
        courseService.deleteCourse(id);
    }
}
