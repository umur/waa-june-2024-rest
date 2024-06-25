package miu.waa.lab2.repository;

import miu.waa.lab2.entity.Course;
import miu.waa.lab2.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepository {
    private final List<Course> courses = new ArrayList<>();

    public CourseRepository() {
        // Create some fake data
        Course course1 = new Course();
        course1.setId(1L);
        course1.setName("Fundamental Programming Practices");
        course1.setCode("CS400");

        Course course2 = new Course();
        course2.setId(2L);
        course2.setName("Modern Programming Practices");
        course2.setCode("CS401");

        Course course3 = new Course();
        course3.setId(3L);
        course3.setName("Enterprise Architecture");
        course3.setCode("CS544");

        Course course4 = new Course();
        course4.setId(4L);
        course4.setName("Algorithms");
        course4.setCode("CS435");

        Course course5 = new Course();
        course5.setId(5L);
        course5.setName("Software Engineering");
        course5.setCode("CS425");

        Course course6 = new Course();
        course6.setId(6L);
        course6.setName("Web Application Programming");
        course6.setCode("CS472");

        List<Course> courses1 = new ArrayList<>();
        courses1.add(course1);
        courses1.add(course2);
        courses1.add(course3);
        courses1.add(course4);

        List<Course> courses2 = new ArrayList<>();
        courses2.add(course2);
        courses2.add(course5);
        courses2.add(course6);

        courses.add(course1);
        courses.add(course2);
        courses.add(course3);
        courses.add(course4);
        courses.add(course5);
        courses.add(course6);

        Student student1 = new Student();
        student1.setId(1L);
        student1.setFirstName("Student");
        student1.setLastName("One");
        student1.setEmail("student1@example.com");
        student1.setMajor("Major 1");
        student1.setGpa(3.5f);
        student1.setCoursesTaken(courses1);

        Student student2 = new Student();
        student2.setId(2L);
        student2.setFirstName("Student");
        student2.setLastName("Two");
        student2.setEmail("student2@example.com");
        student2.setMajor("Major 2");
        student2.setGpa(3.8f);
        student2.setCoursesTaken(courses2);

        Student student3 = new Student();
        student3.setId(3L);
        student3.setFirstName("Student");
        student3.setLastName("Three");
        student3.setEmail("student3@example.com");
        student3.setMajor("Major 2");
        student3.setGpa(3.0f);
        student3.setCoursesTaken(courses2);

        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
    }

    public Boolean create(Course course) {
        int initialSize = courses.size();
        courses.add(course);
        return courses.size() > initialSize;
    }

    public Course getCourseById(Long id) {
        return courses.stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
    }

    public Course update(Long id, Course course) {
        Course existingCourse = getCourseById(id);
        if (existingCourse == null) return null;

        int index = courses.indexOf(existingCourse);
        if (index != -1) {
            courses.set(index, course);
            return course;
        }

        return null;
    }

    public boolean deleteCourseById(Long id) {
        int initialSize = courses.size();
        courses.removeIf(c -> c.getId().equals(id));
        return courses.size() != initialSize;
    }

    public List<Course> getAllCourses() {
        return new ArrayList<>(courses);
    }
}