package miu.waa.restful.service.impl;

import miu.waa.restful.entity.Student;
import miu.waa.restful.repository.StudentRepo;
import miu.waa.restful.service.Function;
import miu.waa.restful.service.Predicate;
import miu.waa.restful.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private static final Function<Integer, Predicate<Student>> identity = new Function<>() {
        @Override
        public Predicate<Student> apply(Integer id) {
            return new Predicate<>() {
                @Override
                public boolean test(Student student) {
                    return student.getId() == id;
                }
            };
        }
    };

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public List<Student> getAll() {
        return studentRepo.getMany();
    }

    @Override
    public Student getOne(int id) {
        return studentRepo.getOne(identity.apply(id));
    }

    @Override
    public Student create(Student student) {
        if (getOne(student.getId()) != null) throw new RuntimeException("Student already added!");
        return studentRepo.create(student);
    }

    @Override
    public void update(int id, Student student) {
        studentRepo.update(identity.apply(id), student);
    }

    @Override
    public void delete(int id) {
       studentRepo.delete(identity.apply(id));
    }

    @Override
    public List<Student> getStudentsByMajor(String major) {
        Predicate<Student> filterByMajor = new Predicate<>() {
            @Override
            public boolean test(Student student) {
                return student.getMajor().equals(major);
            }
        };

        return studentRepo.getMany(filterByMajor);
    }
}
