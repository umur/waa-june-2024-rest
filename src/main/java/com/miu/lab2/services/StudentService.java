package com.miu.lab2.services;

import com.miu.lab2.model.Course;
import com.miu.lab2.model.Student;
import com.miu.lab2.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {
	private final StudentRepository studentRepository;

	public List<Student> getAll() {
		return studentRepository.getAll();
	}

	public Student create(Student student) {
		return studentRepository.create(student);
	}

	public Optional<Student> update(String id, Student student) {
		return studentRepository.update(id, student);
	}

	public boolean deleteById(String id) {
		return studentRepository.deleteById(id);
	}

	public List<Student> getStudentsByMajor(String major) {
		return studentRepository.getStudentsByMajor( major);
	}
}
