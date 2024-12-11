package com.miu.waa.controller;

import com.miu.waa.entity.Course;
import com.miu.waa.service.course.CourseService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @Tag(name = "get", description = "GET methods of Course APIs")
    @GetMapping
    public ResponseEntity<List<Course>> list() {
        List<Course> courses = courseService.findAll();
        if (courses.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(courses);
    }

    @Tag(name = "get", description = "GET methods of Course APIs")
    @GetMapping("/{id}")
    public ResponseEntity<Course> get(@PathVariable Long id) {
        Course course = courseService.find(id);
        if (course == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(course);
    }

    @Tag(name = "post", description = "POST methods of Course APIs")
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Course course) {
        courseService.save(course);
        URI location = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(course.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @Tag(name = "put", description = "PUT methods of Course APIs")
    @PutMapping
    public ResponseEntity<Void> update(@RequestBody Course course) {
        courseService.update(course);
        return ResponseEntity.noContent().build();
    }

    @Tag(name = "delete", description = "DELETE methods of Course APIs")
    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestBody Course course) {
        courseService.delete(course);
        return ResponseEntity.noContent().build();
    }

    @Tag(name = "get", description = "GET methods of Course APIs")
    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<Course>> getCoursesByStudentId(@PathVariable Long studentId) {
       List<Course> courseList = courseService.findByStudentId(studentId);
       if (courseList.isEmpty()) {
            return ResponseEntity.notFound().build();
       }
       return ResponseEntity.ok(courseList);
    }

}
