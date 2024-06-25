package edu.miu.waa_june_2024_rest.repository;


import edu.miu.waa_june_2024_rest.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author kush
 */
@Repository
public class CourseRepository {

    List<Course> courseList =new ArrayList<>();

    public Course save(Course course){
        courseList.add(course);
        return course;
    }

    public List<Course> getAll() {
        return courseList;
    }

    public Course getById(int id) {
        Optional<Course> courseOpt= courseList.stream().filter(x->x.getId()==id).findFirst();
        return courseOpt.orElse(null);
    }

    public Course update(Course course) {
        List<Course> list=courseList.stream().filter(x->x.getId()!=course.getId()).toList();
        courseList.clear();
        courseList.addAll(list);
        courseList.add(course);
        return course;
    }

    public boolean deleteById(int id) {
        courseList=courseList.stream().filter(x->x.getId()!=id).toList();
        return true;
    }

    public List<Course> getByIds(List<Integer> ids) {
        return courseList.stream().filter(x->ids.contains(x.getId())).toList();
    }
}
