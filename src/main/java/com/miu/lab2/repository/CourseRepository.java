package com.miu.lab2.repository;

import com.miu.lab2.model.Course;
import com.miu.lab2.model.Student;
import lombok.Getter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Component
public class CourseRepository {
	private List<Course> courses = new LinkedList<>();

	public List<Course> getAll() {
		return courses;
	}

	public Course create(Course course) {
		courses.add(course);
		return course;
	}

	public Optional<Course> update(String id, Course course) {
		Optional<Course> item = courses.stream().filter(x -> x.getId().equals(id)).findFirst();
		if(item.isEmpty()) {
			return Optional.empty();
		}
		int index = courses.indexOf(item.get());
		courses.set(index, course);
		return Optional.of(course);
	}

	public boolean deleteById(String id) {
		Optional<Course> item = courses.stream().filter(x -> x.getId().equals(id)).findFirst();
		if(item.isEmpty()) {
			return false;
		}
		courses.remove(item.get());
		return true;
	}

	public Optional<Course> getCourseById(String courseId) {
		return courses.stream().filter(x -> x.getId().equals(courseId)).findFirst();
	}
}
