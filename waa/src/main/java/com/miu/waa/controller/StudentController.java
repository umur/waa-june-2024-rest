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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin
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
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.findAll();
        if (students.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(students);
    }

    @Tag(name = "get", description = "GET methods of Student APIs")
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(
            @Parameter(
                    description = "ID of student to be retrieved",
                    required = true)
            @PathVariable Long id) {

        Student student = studentService.find(id);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    @Tag(name = "post", description = "POST methods of Student APIs")
    @PostMapping
    public ResponseEntity<Void> addStudent(@RequestBody Student student) {
        studentService.save(student);
        URI location = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(student.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @Tag(name = "put", description = "PUT methods of Student APIs")
    @PutMapping
    public ResponseEntity<Void> updateStudent(@RequestBody Student student) {
        studentService.update(student);
        return ResponseEntity.noContent().build();
    }

    @Tag(name = "delete", description = "DELETE methods of Student APIs")
    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestBody Student student) {
        studentService.delete(student);
        return ResponseEntity.noContent().build();
    }

    @Tag(name = "delete", description = "DELETE methods of Student APIs")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        studentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @Tag(name = "get", description = "GET methods of Student APIs")
    @GetMapping("/{major}")
    public ResponseEntity<List<Student>> getStudentsByMajor(@PathVariable String major) {
        List<Student> students = studentService.getStudentsByMajor(major);
        if (students.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(students);
    }

}
