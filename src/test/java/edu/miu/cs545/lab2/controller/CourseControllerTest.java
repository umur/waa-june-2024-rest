package edu.miu.cs545.lab2.controller;

import edu.miu.cs545.lab2.entity.Course;
import edu.miu.cs545.lab2.service.CourseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class CourseControllerTest {

    @Mock
    private CourseService courseService;

    @InjectMocks
    private CourseController courseController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(courseController).build();
    }

    @Test
    void shouldGetAllCourses() throws Exception {
        Course course1 = new Course(1, "CS545", "WAA");
        Course course2 = new Course(2, "CS401", "MPP");
        when(courseService.getAllCourses()).thenReturn(Arrays.asList(course1, course2));
        mockMvc.perform(get("/courses")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void shouldSaveCourse() throws Exception {
        mockMvc.perform(post("/courses")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"code\":\"CS545\",\"name\":\"WAA\"}"))
                .andExpect(status().isOk());
    }

    @Test
    void shouldUpdateCourse() throws Exception {
        mockMvc.perform(put("/courses")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"code\":\"CS545\",\"name\":\"WAA\"}"))
                .andExpect(status().isOk());
    }

    @Test
    void shouldDeleteCourse() throws Exception {
        mockMvc.perform(delete("/courses/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}