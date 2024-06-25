package lab1.repository;

import lab1.entity.Course;
import lab1.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {

    private List<Student> students = new ArrayList<Student>();

    public void save(Student student) {
        students.add(student);
    }

    public Student findById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public List<Student> findAll() {
        return students;
    }

    public boolean deleteById(int id) {

        boolean flag = false;

        for (Student std : students) {
            if (std.getId() == id) {
                students.remove(id);
                flag=true;
                break;
            }
        }

        return flag;
    }

    public void update(int id, Student student) {
        students=students.stream().map(s -> s.getId() == id ? s=student:s).toList();
    }

    public List<Student> getByMajor(String major) {
        return students.stream().filter(s-> s.getMajor().equals(major)).toList();
    }

    public List<Course> getCoursesByStudentId(int id) {
        return students.stream().map(s-> (Course) s.getCourseTaken()).toList();
    }
}
