package edu.miu.rest.controller;

import edu.miu.rest.domain.Course;
import edu.miu.rest.domain.Student;
import edu.miu.rest.service.StudentService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents(
            @RequestParam(value = "major", required = false) String major
    ) {
        if (major == null) {
            return ResponseEntity.ok(studentService.findAll());
        } else {
            return ResponseEntity.ok(studentService.getStudentsByMajor(major));
        }
    }

    @GetMapping("/{id}/courses")
    public ResponseEntity<List<Course>> getAllCourses(@PathVariable  int id){
        return ResponseEntity.ok(studentService.getCoursesByStudentId(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id) {
        return ResponseEntity.ok(studentService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Void> addStudent(@RequestBody Student student) {
        studentService.save(student);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "204"),
                    @ApiResponse(responseCode = "500")
            }
    )
    public ResponseEntity<Void> updateStudent(@PathVariable int id,@RequestBody Student student) {
        studentService.update(id, student);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable int id) {
        studentService.deleteStudentById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
