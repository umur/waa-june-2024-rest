package com.miu.waa.controller;

import com.miu.waa.entity.Course;
import com.miu.waa.service.course.CourseService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @Tag(name = "get", description = "GET methods of Course APIs")
    @GetMapping
    public List<Course> list() {
        return courseService.findAll();
    }

    @Tag(name = "get", description = "GET methods of Course APIs")
    @GetMapping("/{id}")
    public Course get(@PathVariable Long id) {
        return courseService.find(id);
    }

    @Tag(name = "post", description = "POST methods of Course APIs")
    @PostMapping
    public Course create(@RequestBody Course course) {
        courseService.save(course);
        return course;
    }

    @Tag(name = "put", description = "PUT methods of Course APIs")
    @PutMapping
    public Course update(@RequestBody Course course) {
        courseService.update(course);
        return course;
    }

    @Tag(name = "delete", description = "DELETE methods of Course APIs")
    @DeleteMapping
    public void delete(@RequestBody Course course) {
        courseService.delete(course);
    }

    @Tag(name = "get", description = "GET methods of Course APIs")
    @GetMapping("/{studentId}")
    public List<Course> getCoursesByStudentId(@PathVariable Long studentId) {
       return courseService.findByStudentId(studentId);
    }

}
