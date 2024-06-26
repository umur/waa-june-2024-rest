package Lab2.repository;

import Lab2.domain.Course;
import Lab2.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepo {

    List<Course> courses = new ArrayList<>();

    public void addCourse(Course course) {
        courses.add(course);
    }

    public List<Course> getCourses() {
        return courses;
    }
    public void removeCourse(int id) {
        Course course = courses.get(id);
        courses.remove(id);
    }
    public Course getCourse(int id) {
        return courses.get(id);
    }
    public void updateCourse(int id, Course course) {
        courses.set(id, course);
    }

}
