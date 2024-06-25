package com.example.demo.repository;

import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class CourseRepo {
    static List<Course> courses = new ArrayList<>(Arrays.asList(
            new Course(1, "Enterprise Architecture", "EA")
    ));
    public Course getCourseById(long id) {
        return courses.stream()
                .filter(course -> course.getId() == id)
                .findFirst()
                .orElse(null);
    }
    public List<Course> getAll() {
        return courses;
    }
    public void createCourse(Course course) {
        courses.add(course);
    }
    public void updateCourse(Course course) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getId() == course.getId()) {
                courses.set(i, course);
                break;
            }
        }
    }
    public void deleteCourse(long id) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getId() == id) {
                courses.remove(i);
                break;
            }
        }
    }
}
