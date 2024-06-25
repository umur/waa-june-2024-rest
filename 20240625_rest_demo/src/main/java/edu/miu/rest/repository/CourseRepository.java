package edu.miu.rest.repository;

import edu.miu.rest.domain.Course;
import edu.miu.rest.exception.ResourceNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class CourseRepository {
    private final List<Course> courses = new ArrayList<>();


    @PostConstruct
    public void init() {
        Course waaCourse = new Course();
        waaCourse.setId(1);
        waaCourse.setName("Web Application Architecture");
        waaCourse.setCode("WAA");

        Course mwaCourse = new Course();
        mwaCourse.setId(2);
        mwaCourse.setName("Modern Web Applications");
        mwaCourse.setCode("MWA");

        Course eaCourse = new Course();
        eaCourse.setId(3);
        eaCourse.setName("Enterprise Applications");
        eaCourse.setCode("EA");

        Course financeCourse = new Course();
        financeCourse.setId(4);
        financeCourse.setName("Finance");
        financeCourse.setCode("FIN");

        Course marketingCourse = new Course();
        marketingCourse.setId(5);
        marketingCourse.setName("Marketing");
        marketingCourse.setCode("MKT");

        courses.addAll(Arrays.asList(waaCourse, mwaCourse, eaCourse, financeCourse, marketingCourse));
    }

    public List<Course> getCourses() {
        return courses;
    }

    public Optional<Course> getCourseById(int id) {
        return courses
                .stream()
                .filter(course -> course.getId() == id)
                .findFirst();
    }

    public void save(Course course) {
        courses.add(course);
    }

    public void deleteById(int id) {
        courses.removeIf(course -> course.getId() == id);
    }


    public void update(int id, Course course) {
        int index = -1;

        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getId() == id) {
                index = i;
            }
        }

        if (index == -1) {
            throw new ResourceNotFoundException("Course with id #" + id + " not found");
        }

        Course courseToUpdate = courses.get(index);

        courseToUpdate.setName(course.getName());
        courseToUpdate.setCode(course.getCode());
    }


}
