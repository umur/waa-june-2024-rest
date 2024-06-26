package com.miu.waa.repository;

import com.miu.waa.entity.Course;
import com.miu.waa.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepository {

    @Autowired
    private StudentRepo studentRepo;

    private List<Course> courses = new ArrayList<>();

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
        Course updateCourse = findById(course.getId());
        if (updateCourse == null) {
           throw new RuntimeException("course not found");
        }
        updateCourse.setName(course.getName());
        updateCourse.setCode(course.getCode());
        System.out.println("updated course " + updateCourse);
    }

    public List<Course> getCoursesByStudentId(Long studentId) {
        Student student = studentRepo.findById(studentId);
        return student.getCoursesTaken();
    }
}
