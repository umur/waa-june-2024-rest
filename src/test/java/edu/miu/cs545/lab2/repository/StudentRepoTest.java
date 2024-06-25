package edu.miu.cs545.lab2.repository;

import edu.miu.cs545.lab2.entity.Course;
import edu.miu.cs545.lab2.entity.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentRepoTest {
    private StudentRepo studentRepo;

    @BeforeEach
    void setUp() {
        studentRepo = new StudentRepo();
    }

    @Test
    void shouldSaveStudent() {
        Student student = new Student(1, "John", "Doe", "john.doe@miu.edu", "CS", 3.5, List.of(new Course(1, "CS545", "WAA")));
        studentRepo.save(student);
        Student savedStudent = studentRepo.getStudent(1);
        assertEquals(student, savedStudent);
    }

    @Test
    void shouldGetAllStudents() {
        Student student1 = new Student(1, "John", "Doe", "john.doe@miu.edu", "CS", 3.5, List.of(new Course(1, "CS545", "WAA")));
        Student student2 = new Student(2, "Jane", "Doe", "jane.doe@miu.edu", "SE", 3.8, List.of(new Course(1, "CS401", "MPP")));
        studentRepo.save(student1);
        studentRepo.save(student2);
        List<Student> students = studentRepo.getAllStudents();
        assertTrue(students.contains(student1));
        assertTrue(students.contains(student2));
    }

    @Test
    void shouldGetStudentById() {
        Student student = new Student(1, "John", "Doe", "john.doe@miu.edu", "CS", 3.5, List.of(new Course(1, "CS545", "WAA")));
        studentRepo.save(student);
        Student fetchedStudent = studentRepo.getStudent(1);
        assertEquals(student, fetchedStudent);
    }

    @Test
    void shouldReturnNullWhenStudentNotFound() {
        Student fetchedStudent = studentRepo.getStudent(1);
        assertNull(fetchedStudent);
    }

    @Test
    void shouldDeleteStudent() {
        Student student = new Student(1, "John", "Doe", "john.doe@miu.edu", "CS", 3.5, List.of(new Course(1, "CS545", "WAA")));
        studentRepo.save(student);
        studentRepo.deleteStudent(1);
        Student deletedStudent = studentRepo.getStudent(1);
        assertNull(deletedStudent);
    }

    @Test
    void shouldUpdateStudent() {
        Student student = new Student(1, "John", "Doe", "john.doe@miu.edu", "CS", 3.5, List.of(new Course(1, "CS545", "WAA")));
        studentRepo.save(student);
        Student updatedStudent = new Student(1, "John", "Smith", "john.smith@miu.edu", "SE", 3.8, List.of(new Course(1, "CS545", "WAA")));
        studentRepo.updateStudent(updatedStudent);
        Student fetchedStudent = studentRepo.getStudent(1);
        assertEquals("John", fetchedStudent.getFirstName());
        assertEquals("Smith", fetchedStudent.getLastName());
        assertEquals("john.smith@miu.edu", fetchedStudent.getEmail());
        assertEquals("SE", fetchedStudent.getMajor());
        assertEquals(3.8, fetchedStudent.getGpa());
    }

    @Test
    void shouldGetStudentsByMajor() {
        Student student1 = new Student(1, "John", "Doe", "john.doe@miu.edu", "CS", 3.5, List.of(new Course(1, "CS545", "WAA")));
        Student student2 = new Student(2, "Jane", "Doe", "jane.doe@miu.edu", "SE", 3.8, List.of(new Course(2, "CS401", "MPP")));
        studentRepo.save(student1);
        studentRepo.save(student2);
        List<Student> students = studentRepo.getStudentsByMajor("CS");
        assertTrue(students.contains(student1));
        assertFalse(students.contains(student2));
    }

    @Test
    void shouldGetCoursesByStudentId() {
        Course course1 = new Course(1, "CS545", "WAA");
        Course course2 = new Course(2, "CS401", "MPP");
        Student student = new Student(1, "John", "Doe", "john.doe@miu.edu", "CS", 3.5, List.of(course1, course2));
        studentRepo.save(student);
        List<Course> courses = studentRepo.getCoursesByStudentId(1);
        assertTrue(courses.contains(course1));
        assertTrue(courses.contains(course2));
    }
}
