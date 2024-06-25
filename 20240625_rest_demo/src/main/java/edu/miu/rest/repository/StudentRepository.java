package edu.miu.rest.repository;

import edu.miu.rest.domain.Course;
import edu.miu.rest.domain.Student;
import edu.miu.rest.exception.ResourceNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {

    private final List<Student> students = new ArrayList<>();

    @PostConstruct
    public void init() {
        // Create a course map for future case
        HashMap<String, Course> courses = new HashMap<>();

        Course waaCourse = new Course();
        waaCourse.setId(1);
        waaCourse.setName("Web Application Architecture");
        waaCourse.setCode("WAA");

        Course mwaCourse = new Course();
        mwaCourse.setId(2);
        mwaCourse.setName("Modern Web Applications");
        mwaCourse.setCode("MWA");

        Course eaCourse = new Course();
        eaCourse.setId(3);
        eaCourse.setName("Enterprise Applications");
        eaCourse.setCode("EA");

        Course financeCourse = new Course();
        financeCourse.setId(4);
        financeCourse.setName("Finance");
        financeCourse.setCode("FIN");

        Course marketingCourse = new Course();
        marketingCourse.setId(5);
        marketingCourse.setName("Marketing");
        marketingCourse.setCode("MKT");

        // for future use cases
        courses.put(waaCourse.getCode(), waaCourse);
        courses.put(mwaCourse.getCode(), mwaCourse);
        courses.put(eaCourse.getCode(), eaCourse);
        courses.put(financeCourse.getCode(), financeCourse);
        courses.put(marketingCourse.getCode(), marketingCourse);

        // create students
        Student student1 = new Student();
        student1.setId(1);
        student1.setFirstName("John");
        student1.setLastName("Doe");
        student1.setEmail("john.doe@miu.edu");
        student1.setMajor("Computer Science");
        student1.setGpa(3.5);
        student1.setCoursesTaken(Arrays.asList(waaCourse, mwaCourse, eaCourse));

        Student student2 = new Student();
        student2.setId(2);
        student2.setFirstName("Jane");
        student2.setLastName("Smith");
        student2.setEmail("jane.smith@miu.edu");
        student2.setMajor("Computer Science");
        student2.setGpa(3.8);
        student2.setCoursesTaken(Arrays.asList(eaCourse, mwaCourse));

        Student student3 = new Student();
        student3.setId(3);
        student3.setFirstName("Alice");
        student3.setLastName("Johnson");
        student3.setEmail("alice.johnson@miu.edu");
        student3.setMajor("Computer Science");
        student3.setGpa(3.9);
        student3.setCoursesTaken(Arrays.asList(eaCourse, mwaCourse));

        Student student4 = new Student();
        student4.setId(4);
        student4.setFirstName("Bob");
        student4.setLastName("Brown");
        student4.setEmail("bob.brown@miu.edu");
        student4.setMajor("MBA");
        student4.setGpa(3.6);
        student4.setCoursesTaken(Arrays.asList(financeCourse, marketingCourse));

        Student student5 = new Student();
        student5.setId(5);
        student5.setFirstName("Charlie");
        student5.setLastName("Davis");
        student5.setEmail("charlie.davis@miu.edu");
        student5.setMajor("MBA");
        student5.setGpa(3.7);
        student5.setCoursesTaken(Arrays.asList(marketingCourse, financeCourse));

        students.addAll(List.of(student1, student2, student3, student4, student5));

    }


    public List<Student> getStudents() {
        return students;
    }

    public Optional<Student> getStudentById(int id) {
        return students.stream().filter(student -> student.getId() == id).findFirst();
    }

    public List<Student> getStudentsByMajor(String major) {
        return students.stream()
                .filter(student -> student.getMajor().equals(major))
                .toList();
    }

    public List<Course> getCoursesByStudentId(int studentId) {
        return students.stream()
                .filter(student -> student.getId().equals(studentId))
                .findFirst()
                .map(Student::getCoursesTaken)
                .orElse(new ArrayList<>());
    }

    public void deleteStudentById(int id) {
        students.removeIf(student -> student.getId() == id);
    }

    public void add(Student student) {
        students.add(student);
    }

    public void updateStudent(int id, Student student) {
        int index = -1;

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                index = i;
            }
        }

        if (index == -1){
            throw new ResourceNotFoundException("Student with id " + id + " not found");
        }

        Student studentToUpdate = students.get(index);

        studentToUpdate.setFirstName(student.getFirstName());
        studentToUpdate.setLastName(student.getLastName());
        studentToUpdate.setEmail(student.getEmail());
        studentToUpdate.setMajor(student.getMajor());
        studentToUpdate.setGpa(student.getGpa());
        studentToUpdate.setCoursesTaken(student.getCoursesTaken());
    }
}
