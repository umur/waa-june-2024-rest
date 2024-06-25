package edu.miu.cs545.lab2.controller;

import edu.miu.cs545.lab2.entity.Course;
import edu.miu.cs545.lab2.entity.Student;
import edu.miu.cs545.lab2.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class StudentControllerTest {

    @Mock
    private StudentService studentService;

    @InjectMocks
    private StudentController studentController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(studentController).build();
    }

    @Test
    void shouldGetAllStudents() throws Exception {
        Student student1 = new Student(1, "John", "Doe", "john.doe@miu.edu", "CS", 3.5, List.of(new Course(1, "CS545", "WAA")));
        Student student2 = new Student(2, "Jane", "Doe", "jane.doe@miu.edu", "SE", 3.8, List.of(new Course(2, "CS401", "MPP")));
        when(studentService.getAllStudents()).thenReturn(Arrays.asList(student1, student2));
        mockMvc.perform(get("/students")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void shouldSaveStudent() throws Exception {
        mockMvc.perform(post("/students")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"firstName\":\"John\",\"lastName\":\"Doe\",\"email\":\"john.doe@miu.edu\",\"major\":\"CS\",\"gpa\":3.5,\"courses\":[{\"id\":1,\"code\":\"CS545\",\"name\":\"WAA\"}]}"))
                .andExpect(status().isOk());
    }

    @Test
    void shouldUpdateStudent() throws Exception {
        mockMvc.perform(put("/students")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"firstName\":\"John\",\"lastName\":\"Doe\",\"email\":\"john.doe@miu.edu\",\"major\":\"CS\",\"gpa\":3.5,\"courses\":[{\"id\":1,\"code\":\"CS545\",\"name\":\"WAA\"}]}"))
                .andExpect(status().isOk());
    }

    @Test
    void shouldDeleteStudent() throws Exception {
        mockMvc.perform(delete("/students/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void shouldGetStudentsByMajor() throws Exception {
        Student student1 = new Student(1, "John", "Doe", "john.doe@miu.edu", "CS", 3.5, List.of(new Course(1, "CS545", "WAA")));
        when(studentService.getStudentsByMajor("CS")).thenReturn(Arrays.asList(student1));
        mockMvc.perform(get("/students/major/CS")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void shouldGetCoursesByStudentId() throws Exception {
        Course course1 = new Course(1, "CS545", "WAA");
        Course course2 = new Course(2, "CS401", "MPP");
        when(studentService.getCoursesByStudentId(1)).thenReturn(Arrays.asList(course1, course2));
        mockMvc.perform(get("/students/1/courses")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}