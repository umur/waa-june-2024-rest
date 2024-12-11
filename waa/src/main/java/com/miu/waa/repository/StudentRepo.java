package com.miu.waa.repository;

import com.miu.waa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

    List<Student> findByMajor(String major);

//    private static List<Student> students = new ArrayList<>();
//
//    public void save(Student student) {
//        students.add(student);
//    }
//
//    public List<Student> findAll() {
//        return students;
//    }
//
//    public Student findById(Long id) {
//        return students.stream().filter(student -> student.getId().equals(id)).findFirst().orElse(null);
//    }
//
//    public void deleteById(Long id) {
//        students.removeIf(student -> student.getId().equals(id));
//    }
//
//    public void update(Student student) {
//        Student updatedStudent = findById(student.getId());
//        if (updatedStudent != null) {
//            updatedStudent.setGpa(student.getGpa());
//            updatedStudent.setEmail(student.getEmail());
//            updatedStudent.setMajor(student.getMajor());
//            updatedStudent.setFirstName(student.getFirstName());
//            updatedStudent.setLastName(student.getLastName());
//            updatedStudent.setCoursesTaken(student.getCoursesTaken());
//        }
//        else throw new RuntimeException("Student not found");
//    }
//
//
//    public List<Student> findByMajor(String major) {
//        return students.stream().filter(student -> student.getMajor().equals(major))
//                .collect(Collectors.toList());
//    }
}
