package cs545.lab.lab02.repository;

import cs545.lab.lab02.domain.Course;
import cs545.lab.lab02.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class StudentRepo {

    List<Student> students;


    public StudentRepo() {
        this.students = new ArrayList<>();

        List<Course> csCourses = new ArrayList<>();
        csCourses.add(new Course(1, "WAA", "545"));
        csCourses.add(new Course(2, "EA", "522"));
        csCourses.add(new Course(3, "ASD", "525"));

        List<Course> mbaCourses = new ArrayList<>();
        mbaCourses.add(new Course(1, "BA", "555"));
        mbaCourses.add(new Course(2, "SA", "512"));
        mbaCourses.add(new Course(3, "BSA", "566"));

        this.students.add(new Student(1, "Bryan", "Phone", "bryan@miu.edu", "CS", "3.8", csCourses));
        this.students.add(new Student(2, "John", "Mike", "mike@miu.edu", "MBA", "3.0", mbaCourses));

    }


    public Student saveStudent(Student student) {
        students.add(student);
        return student;
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public Student getStudent(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public void deleteStudent(int id) {
        students.removeIf(student -> student.getId() == id);
    }

    public List<Student> getStudentsByMajor(String major) {
        List<Student> stdList = new ArrayList<>();
        for (Student student : students) {
            if (student.getMajor().equalsIgnoreCase(major)) {
                stdList.add(student);
            }
        }
        return stdList;
    }


}
