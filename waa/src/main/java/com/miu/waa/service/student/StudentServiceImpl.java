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
        return studentRepo.findById(id);
    }

    @Override
    public void save(Student student) {
        studentRepo.save(student);
    }

    @Override
    public void update(Student student) {
        studentRepo.update(student);
    }

    @Override
    public void delete(Student student) {
        studentRepo.deleteById(student.getId());
    }

    @Override
    public void deleteById(Long id) {
        studentRepo.deleteById(id);
    }
}
