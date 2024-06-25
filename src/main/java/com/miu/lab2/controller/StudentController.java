package com.miu.lab2.controller;

import com.miu.lab2.model.Student;
import com.miu.lab2.services.StudentCourseService;
import com.miu.lab2.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
	private final StudentService studentService;
	private final StudentCourseService studentCourseService;

	@GetMapping
	public List<Student> getAll() {
		return studentService.getAll();
	}

	@GetMapping("/lookup")
	public List<Student> getStudentsByMajor(@RequestParam String major) {
		return studentService.getStudentsByMajor(major);
	}

	@PostMapping
	public Student create(@RequestBody Student student) {
		return studentService.create(student);
	}
	@GetMapping("/register")
	public boolean courseRegister(@RequestParam String studentId, @RequestParam String courseId) {
		return studentCourseService.registerCourseToStudent(studentId, courseId);
	}

	@PutMapping("/{id}")
	public Student update(@PathVariable String id, @RequestBody Student student) throws Exception {
		Optional<Student> updateItem = studentService.update(id, student);
		if (updateItem.isEmpty()) {
			throw new Exception("Item invalid");
		}
		return updateItem.get();
	}

	@DeleteMapping("/{id}")
	public boolean deleteById(@PathVariable String id) {
		return studentService.deleteById(id);
	}
}
