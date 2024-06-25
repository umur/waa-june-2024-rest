package com.restlab.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Course {

    private int id;
    private String name;
    private String code;

    public Course(){}

    public Course(int id, String name, String code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }
}
