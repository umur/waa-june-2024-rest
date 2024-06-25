package miu.waa.restful.service.impl;

import miu.waa.restful.entity.Course;
import miu.waa.restful.entity.Student;
import miu.waa.restful.repository.CourseRepo;
import miu.waa.restful.service.CourseService;
import miu.waa.restful.service.Function;
import miu.waa.restful.service.Predicate;
import miu.waa.restful.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    private static final Function<Integer, Predicate<Course>> identity = new Function<>() {
        @Override
        public Predicate<Course> apply(Integer id) {
            return new Predicate<>() {
                @Override
                public boolean test(Course course) {
                    return course.getId() == id;
                }
            };
        }
    };

    @Autowired
    private CourseRepo courseRepo;
    @Autowired
    private StudentService studentService;

    @Override
    public List<Course> getAll() {
        return courseRepo.getMany();
    }

    @Override
    public Course getOne(int id) {
        return courseRepo.getOne(identity.apply(id));
    }

    @Override
    public Course create(Course course) {
        if (getOne(course.getId()) != null) throw new RuntimeException("Course already added!");

        return courseRepo.create(course);
    }

    @Override
    public void update(int id, Course course) {
        courseRepo.update(identity.apply(id), course);
    }

    @Override
    public void delete(int id) {
        courseRepo.delete(identity.apply(id));
    }

    @Override
    public List<Course> getCoursesByStudentId(int studentId) {
        List<Course> coursesTaken = new ArrayList<>();
        Student student = studentService.getOne(studentId);
        if (student != null) coursesTaken = student.getCoursesTaken();

        return coursesTaken;
    }
}
