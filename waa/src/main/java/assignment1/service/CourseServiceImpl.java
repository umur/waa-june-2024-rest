package assignment1.service;

import assignment1.domain.Course;
import assignment1.repository.CourseRepository;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService{

    private CourseRepository repository;

    public CourseServiceImpl(CourseRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Course> findAll() {
        return repository.findAll();
    }

    @Override
    public Course findById(int id)  {
        Optional<Course> course = repository.findById(id);
        return course.get();
    }

    @Override
    public void save(Course course) {
        repository.save(course);
    }

    @Override
    public void update(Course course) {
        repository.update(course);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }
}
