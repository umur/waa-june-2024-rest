package lab1.repository;
import lab1.entity.Course;
import lab1.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepository {

    private List<Course> courses = new ArrayList<Course>();

    public void save(Course course) {
        courses.add(course);
    }

    public Course findById(int id) {
        for (Course course : courses) {
            if (course.getId() == id) {
                return course;
            }
        }
        return null;
    }

    public List<Course> findAll() {
        return courses;
    }

    public boolean deleteById(int id) {
        boolean flag = false;

        for (Course course : courses) {
            if (course.getId() == id) {
                courses.remove(id);
                flag=true;
                break;
            }
        }

        return flag;
    }

    public void update(int id, Course course) {
        if(findById(id) == null) {
            throw new RuntimeException("Course name cannot be found");
        }
        courses=courses.stream().map(c -> c.getId() == id ? c=course:c).toList();
    }

}
