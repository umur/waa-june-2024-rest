package com.miu.waa.controller;

import com.miu.waa.entity.Student;
import com.miu.waa.service.student.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @Tag(name = "get", description = "GET methods of Student APIs")
    @Operation(summary = "get all students", description = "description...")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Student.class)) }),
            @ApiResponse(responseCode = "404", description = "Employee not found",
                    content = @Content) })
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.findAll();
    }

    @Tag(name = "get", description = "GET methods of Student APIs")
    @GetMapping("/{id}")
    public Student getStudentById(
            @Parameter(
                    description = "ID of student to be retrieved",
                    required = true)
            @PathVariable Long id) {
        return studentService.find(id);
    }

    @Tag(name = "post", description = "POST methods of Student APIs")
    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        studentService.save(student);
        return student;
    }

    @Tag(name = "put", description = "PUT methods of Student APIs")
    @PutMapping
    public Student updateStudent(@RequestBody Student student) {
        studentService.update(student);
        return student;
    }

    @Tag(name = "delete", description = "DELETE methods of Student APIs")
    @DeleteMapping
    public void delete(@RequestBody Student student) {
        studentService.delete(student);
    }

    @Tag(name = "delete", description = "DELETE methods of Student APIs")
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        studentService.deleteById(id);
    }

    @Tag(name = "get", description = "GET methods of Student APIs")
    @GetMapping("/{major}")
    public List<Student> getStudentsByMajor(@PathVariable String major) {
        return studentService.getStudentsByMajor(major);
    }

}
