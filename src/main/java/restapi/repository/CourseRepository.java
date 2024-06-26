package restapi.repository;

import org.springframework.stereotype.Repository;
import restapi.domain.Course;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CourseRepository {
    private List<Course> courses = new ArrayList<>();
    public void save(Course course) {
        courses.add(course);
    }
    public List<Course> findAll() {
        return courses;
    }

    public Course findById(Integer id) {
        Optional<Course> courseByIdOptional = courses.stream()
                .filter(course -> course.getId().equals(id))
                .findFirst();
        if(courseByIdOptional.isPresent()) {
            return courseByIdOptional.get();
        }
        return null;
    }

    public void deleteById(Integer id) {
        courses.removeIf(course -> course.getId().equals(id));
    }
}
