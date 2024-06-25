package com.restlab.repository;

import org.springframework.stereotype.Repository;

import com.restlab.entity.Course;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepository {

    private List<Course> courses= new ArrayList<>();

    public void createCourse(Course course){
        courses.add(course);
    }

    public List<Course> getAllCourses(){
        return courses;
    }

    public Course getCourseById(int id){
        return courses.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Course updateCourse(int id,Course course){
        for(int i=0; i<courses.size(); i++){
            if(id == courses.get(i).getId()){
                courses.set(i, course);
                return course;
            }
        }
        return null;
    }

    public void deleteCourseById(int id){
        courses.removeIf(c -> c.getId() == id);
    }
}
