package assignment1.repository;

import assignment1.domain.Course;
import assignment1.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CourseRepository {
    private List<Course> courses=new ArrayList<>();

    public List<Course> findAll() {
        return courses;
    }

    public Optional<Course> findById(int id) {
        Optional<Course> course=courses.stream().filter(c -> c.getId() == id).findFirst();
        return course;
    }

    public Course save(Course course) {
        courses.add(course);
        return course;
    }

    public Course update(Course course) {
        int index = -1;
        for(int i=0;i<courses.size();i++) {
            if(courses.get(i).getId()==course.getId()) {
                index = i;
            }
        }
        if (index != -1) {
            courses.set(index, course);
        }
        return course;
    }

    public void delete(int id) {
        for (Course course : courses) {
            if (course.getId() == id) {
                courses.remove(course);
                break;
            }
        }
    }
}
