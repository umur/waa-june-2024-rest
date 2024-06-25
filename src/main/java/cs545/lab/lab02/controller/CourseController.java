package cs545.lab.lab02.controller;

import cs545.lab.lab02.domain.Course;
import cs545.lab.lab02.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{studentId}/courses")
    public List<Course> getCoursesByStudentId(@PathVariable int studentId) {
        return courseService.getCoursesByStudentId(studentId);
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable int id) {
        return courseService.getCourseById(id);
    }

    @PostMapping
    public Course addCourse(@RequestBody Course course) {
        return courseService.addCourse(course);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable int id, @RequestBody Course course) {
        Course resCourse = courseService.getCourseById(id);

        if (resCourse != null) {
            resCourse.setName(course.getName());
            resCourse.setCode(course.getCode());
            return ResponseEntity.ok(courseService.updateCourse(resCourse));
        } else {
            return ResponseEntity.notFound().build();
        }


    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable int id) {
        courseService.deleteCourse(id);
    }


}
