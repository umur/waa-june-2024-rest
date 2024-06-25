package edu.miu.cs545.lab2.repository;

import edu.miu.cs545.lab2.entity.Course;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CourseRepoTest {
    private CourseRepo courseRepo;

    @BeforeEach
    void setUp() {
        courseRepo = new CourseRepo();
    }

    @Test
    void shouldSaveCourse() {
        Course course = new Course(1, "CS545", "WAA");
        courseRepo.save(course);
        Course savedCourse = courseRepo.getCourse(1);
        assertEquals(course, savedCourse);
    }

    @Test
    void shouldGetAllCourses() {
        Course course1 = new Course(1, "CS545", "WAA");
        Course course2 = new Course(2, "CS401", "MPP");
        courseRepo.save(course1);
        courseRepo.save(course2);
        List<Course> courses = courseRepo.getAllCourses();
        assertTrue(courses.contains(course1));
        assertTrue(courses.contains(course2));
    }

    @Test
    void shouldGetCourseById() {
        Course course = new Course(1, "CS545", "WAA");
        courseRepo.save(course);
        Course fetchedCourse = courseRepo.getCourse(1);
        assertEquals(course, fetchedCourse);
    }

    @Test
    void shouldReturnNullWhenCourseNotFound() {
        Course fetchedCourse = courseRepo.getCourse(1);
        assertNull(fetchedCourse);
    }

    @Test
    void shouldDeleteCourse() {
        Course course = new Course(1, "CS545", "WAA");
        courseRepo.save(course);
        courseRepo.deleteCourse(1);
        Course deletedCourse = courseRepo.getCourse(1);
        assertNull(deletedCourse);
    }

    @Test
    void shouldUpdateCourse() {
        Course course = new Course(1, "CS545", "WAA");
        courseRepo.save(course);
        Course updatedCourse = new Course(1, "Web Application Architecture", "CS545");
        courseRepo.updateCourse(updatedCourse);
        Course fetchedCourse = courseRepo.getCourse(1);
        assertEquals("Web Application Architecture", fetchedCourse.getName());
    }
}
