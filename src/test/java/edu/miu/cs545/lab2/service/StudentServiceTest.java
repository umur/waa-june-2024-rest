package edu.miu.cs545.lab2.service;

import edu.miu.cs545.lab2.entity.Course;
import edu.miu.cs545.lab2.entity.Student;
import edu.miu.cs545.lab2.repository.StudentRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentServiceTest {
    @Mock
    private StudentRepo studentRepo;

    @InjectMocks
    private StudentService studentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldSaveStudent() {
        Student student = new Student(1, "John", "Doe", "john.doe@miu.edu", "CS", 3.5, List.of(new Course(1, "CS545", "WAA")));
        studentService.save(student);
        verify(studentRepo, times(1)).save(student);
    }

    @Test
    void shouldDeleteStudent() {
        studentService.deleteStudent(1);
        verify(studentRepo, times(1)).deleteStudent(1);
    }

    @Test
    void shouldUpdateStudent() {
        Student student = new Student(1, "John", "Doe", "john.doe@miu.edu", "CS", 3.5, List.of(new Course(1, "CS545", "WAA")));
        studentService.updateStudent(student);
        verify(studentRepo, times(1)).updateStudent(student);
    }

    @Test
    void shouldGetStudent() {
        Student student = new Student(1, "John", "Doe", "john.doe@miu.edu", "CS", 3.5, List.of(new Course(1, "CS545", "WAA")));
        when(studentRepo.getStudent(1)).thenReturn(student);
        Student fetchedStudent = studentService.getStudent(1);
        assertEquals(student, fetchedStudent);
    }

    @Test
    void shouldGetAllStudents() {
        Student student1 = new Student(1, "John", "Doe", "john.doe@miu.edu", "CS", 3.5, List.of(new Course(1, "CS545", "WAA")));
        Student student2 = new Student(2, "Jane", "Doe", "jane.doe@miu.edu", "SE", 3.8, List.of(new Course(2, "CS401", "MPP")));
        when(studentRepo.getAllStudents()).thenReturn(Arrays.asList(student1, student2));
        List<Student> students = studentService.getAllStudents();
        assertTrue(students.contains(student1));
        assertTrue(students.contains(student2));
    }

    @Test
    void shouldGetStudentsByMajor() {
        Student student1 = new Student(1, "John", "Doe", "john.doe@miu.edu", "CS", 3.5, List.of(new Course(1, "CS545", "WAA")));
        Student student2 = new Student(2, "Jane", "Doe", "jane.doe@miu.edu", "SE", 3.8, List.of(new Course(2, "CS401", "MPP")));
        when(studentRepo.getStudentsByMajor("CS")).thenReturn(Arrays.asList(student1));
        List<Student> students = studentService.getStudentsByMajor("CS");
        assertTrue(students.contains(student1));
        assertFalse(students.contains(student2));
    }

    @Test
    void shouldGetCoursesByStudentId() {
        Course course1 = new Course(1, "CS545", "WAA");
        Course course2 = new Course(2, "CS401", "MPP");
        Student student = new Student(1, "John", "Doe", "john.doe@miu.edu", "CS", 3.5, List.of(course1, course2));
        when(studentRepo.getCoursesByStudentId(1)).thenReturn(Arrays.asList(course1, course2));
        List<Course> courses = studentService.getCoursesByStudentId(1);
        assertTrue(courses.contains(course1));
        assertTrue(courses.contains(course2));
    }
}