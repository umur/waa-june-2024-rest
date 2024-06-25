package edu.miu.cs545.lab2.service;

import edu.miu.cs545.lab2.entity.Course;
import edu.miu.cs545.lab2.repository.CourseRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class CourseServiceTest {
    @Mock
    private CourseRepo courseRepo;

    @InjectMocks
    private CourseService courseService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldSaveCourse() {
        Course course = new Course(1, "CS545", "WAA");
        courseService.save(course);
        verify(courseRepo, times(1)).save(course);
    }

    @Test
    void shouldDeleteCourse() {
        courseService.deleteCourse(1);
        verify(courseRepo, times(1)).deleteCourse(1);
    }

    @Test
    void shouldUpdateCourse() {
        Course course = new Course(1, "CS545", "WAA");
        courseService.updateCourse(course);
        verify(courseRepo, times(1)).updateCourse(course);
    }

    @Test
    void shouldGetCourse() {
        Course course = new Course(1, "CS545", "WAA");
        when(courseRepo.getCourse(1)).thenReturn(course);
        Course fetchedCourse = courseService.getCourse(1);
        assertEquals(course, fetchedCourse);
    }

    @Test
    void shouldGetAllCourses() {
        Course course1 = new Course(1, "CS545", "WAA");
        Course course2 = new Course(2, "CS401", "MPP");
        when(courseRepo.getAllCourses()).thenReturn(Arrays.asList(course1, course2));
        List<Course> courses = courseService.getAllCourses();
        assertTrue(courses.contains(course1));
        assertTrue(courses.contains(course2));
    }
}