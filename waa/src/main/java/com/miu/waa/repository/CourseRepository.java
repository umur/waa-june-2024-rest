package com.miu.waa.repository;

import com.miu.waa.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepository {

    private static List<Course> courses = new ArrayList<>();

    public void add(Course course) {
        courses.add(course);
    }

    public List<Course> getCourses() {
        return courses;
    }

    public Course findById(Long id) {
        return courses.stream().filter(course -> course.getId().equals(id)).findFirst().orElse(null);
    }

    public void deleteById(Long id) {
        courses.removeIf(course -> course.getId().equals(id));
    }

    public void update(Course course) {
        for (Course course1 : courses) {
            if (course1.getId().equals(course.getId())) {
                course1.setName(course.getName());
                course1.setCode(course.getCode());
            }
        }
    }
}
