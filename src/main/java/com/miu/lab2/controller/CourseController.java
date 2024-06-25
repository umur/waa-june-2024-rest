package com.miu.lab2.controller;

import com.miu.lab2.model.Course;
import com.miu.lab2.services.CourseService;
import com.miu.lab2.services.StudentCourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {
	private final CourseService courseService;
	private final StudentCourseService studentCourseService;

	@GetMapping
	public List<Course> get() {
		return courseService.getAll();
	}

	@GetMapping("/student/{id}")
	public List<Course> getCourseByStudentId(@PathVariable String id) {
		return studentCourseService.getCoursesByStudentId(id);
	}

	@PostMapping
	public Course create(@RequestBody Course course) {
		System.out.println(course);
		return courseService.create(course);
	}

	@PutMapping("/{id}")
	public Course update(@PathVariable String id, @RequestBody Course course) throws Exception {
		Optional<Course> updateItem = courseService.update(id, course);
		if (updateItem.isEmpty()) {
			throw new Exception("Item invalid");
		}
		return updateItem.get();
	}

	@DeleteMapping("/{id}")
	public boolean deleteById(@PathVariable String id) {
		return courseService.deleteById(id);
	}
}
