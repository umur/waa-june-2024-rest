package com.miu.lab2.services;

import com.miu.lab2.model.Course;
import com.miu.lab2.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseService {
	private final CourseRepository courseRepository;

	public List<Course> getAll() {
		return courseRepository.getAll();
	}

	public Course create(Course course) {
		return courseRepository.create(course);
	}

	public Optional<Course> update(String id, Course course) {
		return courseRepository.update(id , course);
	}

	public boolean deleteById(String id) {
		return courseRepository.deleteById(id);
	}
}
