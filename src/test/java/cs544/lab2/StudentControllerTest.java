package cs544.lab2;

import cs544.lab2.entity.Course;
import cs544.lab2.entity.Student;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.test.mock.mockito.MockBean;
import cs544.lab2.service.StudentService;

import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentControllerTest {
    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate restTemplate;
    @MockBean
    private StudentService studentService;
    @BeforeEach
    public void setup() {
        Student s1 = new Student(1, "Frank", "Brown","test@email.com","CS",800,
                List.of(
                        new Course(1, "EA", "Easy A"),
                        new Course(2, "WAA", "Web App Arch")
                ));

        Student s2 = new Student(2, "John", "Doe","abc@email.com","CS",900,
                List.of(
                        new Course(3, "EA", "Easy A"),
                        new Course(4, "WAA", "Web App Arch")
                ));

        Student s3 = new Student(3, "Jane", "Doe","xyz@email.com","CS",1000,
                List.of(
                        new Course(5, "EA", "Easy A"),
                        new Course(6, "WAA", "Web App Arch")
                ));

        when(studentService.getStudentsByMajor("CS")).thenReturn(List.of(s1, s2, s3));
        when(studentService.getCoursesByStudentId(1)).thenReturn(s1.getCourses());
        when(studentService.getCoursesByStudentId(2)).thenReturn(s2.getCourses());
        when(studentService.getCoursesByStudentId(3)).thenReturn(s3.getCourses());
        when(studentService.getStudent(1)).thenReturn(s1);
        when(studentService.getStudent(2)).thenReturn(s2);
        when(studentService.getStudent(3)).thenReturn(s3);
    }
    @Test
    public void testGetStudentsByMajor() {
        String response = this
                .restTemplate
                .getForObject("http://localhost:" + port + "/students/major/CS", String.class);
        assert(response.contains("Frank"));
    }
    @Test
    public void testGetCoursesByStudentId() {
        String response = this
                .restTemplate
                .getForObject("http://localhost:" + port + "/students/2/courses", String.class);
        assert(response.contains("John"));
    }

}
