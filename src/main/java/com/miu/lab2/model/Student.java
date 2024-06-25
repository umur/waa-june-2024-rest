package com.miu.lab2.model;

import lombok.Getter;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Getter
public class Student {

	String id = UUID.randomUUID().toString();
	String firstName, lastName, email, major;
	Double gpa;
	List<Course> coursesTaken = new LinkedList<>();

	public void addCourse(Course course) {
		this.coursesTaken.add(course);
	}
}
