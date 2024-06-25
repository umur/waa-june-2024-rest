package edu.miu.waa_june_2024_rest.service;

import edu.miu.waa_june_2024_rest.entity.Course;

import java.util.List;

/**
 * @author kush
 */
public interface CourseService {
    List<Course> getAll();

    Course getById(int id);

    Course save(Course course);

    Course update(int id, Course course);

    boolean delete(int id);

    List<Course> getByIds(List<Integer> ids);
}
