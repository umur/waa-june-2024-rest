package com.miu.lab2.repository;

import com.miu.lab2.model.Course;
import com.miu.lab2.model.Student;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Component
public class StudentRepository {
	private List<Student> students = new LinkedList<>();

	public List<Student> getAll() {
		return students;
	}

	public Optional<Student> getStudentById(String id) {
		return students.stream().filter(x -> x.getId().equals(id)).findFirst();
	}

	public Student create(Student student) {
		students.add(student);
		return student;
	}

	public Optional<Student> update(String id, Student student) {
		Optional<Student> item = students.stream().filter(x -> x.getId().equals(id)).findFirst();
		if (item.isEmpty()) {
			return Optional.empty();
		}
		int index = students.indexOf(item.get());
		students.set(index, student);
		return Optional.of(student);
	}

	public boolean deleteById(String id) {
		Optional<Student> item = students.stream().filter(x -> x.getId().equals(id)).findFirst();
		if (item.isEmpty()) {
			return false;
		}
		students.remove(item.get());
		return true;
	}

	public List<Student> getStudentsByMajor(String major) {
		return students.stream().filter(x -> x.getMajor().equals(major)).toList();
	}

	public boolean registerCourseToStudent(String studentId, Course course) {
		Optional<Student> item = students.stream().filter(x -> x.getId().equals(studentId)).findFirst();
		if (item.isEmpty()) {
			return false;
		}
		Student student = item.get();
		int index = students.indexOf(student);
		student.addCourse(course);
		students.set(index, student);
		return true;
	}
}
