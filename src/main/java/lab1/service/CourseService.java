package lab1.service;
import lab1.entity.Course;

import java.util.List;

public interface CourseService {

    public void save(Course course);
    public Course getCourse(int id);
    public List<Course> getAllCourses();
    public void deleteCourse(int id);
    public void updateCourse(int id,Course course);
}
