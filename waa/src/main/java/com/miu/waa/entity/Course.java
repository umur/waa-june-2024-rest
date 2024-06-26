package com.miu.waa.entity;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @NotNull
    private Long id;
    @NotNull
    @Size(min = 1, max = 20)
    private String name;
    @NotNull
    @Size(min = 1, max = 20)
    private String code;

//    private List<Student> students = new ArrayList<>();
//
//    public void addStudent(Student student) {
//        students.add(student);
//    }
}
