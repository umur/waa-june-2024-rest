package com.miu.lab2.services;

import com.miu.lab2.model.Course;
import com.miu.lab2.model.Student;
import com.miu.lab2.repository.CourseRepository;
import com.miu.lab2.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentCourseService {
	private final CourseRepository courseRepository;
	private final StudentRepository studentRepository;
	public List<Course> getCoursesByStudentId(String studentId) {
		Optional<Student> student = studentRepository.getStudentById(studentId);
		if(student.isEmpty()) {
			return List.of();
		}

		return student.get().getCoursesTaken();
	}

	public boolean registerCourseToStudent(String studentId, String courseId) {
		Optional<Course> course = courseRepository.getCourseById(courseId);
		return course.filter(value -> studentRepository.registerCourseToStudent(studentId, value)).isPresent();
	}
}
