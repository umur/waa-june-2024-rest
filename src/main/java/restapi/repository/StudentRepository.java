package restapi.repository;

import org.springframework.stereotype.Repository;
import restapi.domain.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class StudentRepository {
    private List<Student> students = new ArrayList<>();

    public void save(Student student) {
        students.add(student);
    }

    public List<Student> findAll() {
        return students;
    }

    public Student findById(Integer id) {
        Optional<Student> studentOptional = students.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst();
        if (studentOptional.isPresent()) {
            return studentOptional.get();
        }
        return null;
    }

    public void deleteById(Integer id) {
        students.removeIf(student -> student.getId().equals(id));
    }

    public List<Student> findByMajor(String major) {
        return students.stream()
                .filter(student -> student.getMajor().equalsIgnoreCase(major))
                .toList();
    }
}
