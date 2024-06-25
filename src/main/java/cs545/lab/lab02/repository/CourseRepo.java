package cs545.lab.lab02.repository;

import cs545.lab.lab02.domain.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepo {

    List<Course> courses;


    public CourseRepo() {
        this.courses = new ArrayList<>();
        this.courses.add(new Course(1, "WAA", "545"));
        this.courses.add(new Course(2, "EA", "522"));
        this.courses.add(new Course(3, "ASD", "525"));
        this.courses.add(new Course(4, "MPP", "420"));
        this.courses.add(new Course(5, "FPP", "390"));
    }

    public Course saveCourse(Course course) {
        courses.add(course);
        return course;
    }

    public List<Course> getAllCourses() {
        return courses;
    }

    public Course getCourseById(int id) {
        for (Course course : courses) {
            if (course.getId() == id) {
                return course;
            }
        }
        return null;
    }

    public void deleteCourseById(int id) {
        courses.removeIf(course -> course.getId() == id);
    }


}
