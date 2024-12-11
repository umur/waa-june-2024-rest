package com.miu.waa.service.student;

import com.miu.waa.entity.Student;
import com.miu.waa.repository.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;

    @Override
    public List<Student> findAll() {
        return studentRepo.findAll();
    }

    @Override
    public Student find(Long id) {
        return studentRepo.findById(id).orElseThrow();
    }

    @Override
    public void save(Student student) {
        studentRepo.save(student);
    }

    @Override
    public void update(Student student) {
        studentRepo.save(student);
    }

    @Override
    public void delete(Student student) {
        studentRepo.delete(student);
    }

    @Override
    public void deleteById(Long id) {
        studentRepo.deleteById(id);
    }

    @Override
    public List<Student> getStudentsByMajor(String major) {
        return studentRepo.findByMajor(major);
    }

}
