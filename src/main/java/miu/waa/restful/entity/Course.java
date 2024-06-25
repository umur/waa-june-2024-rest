package miu.waa.restful.entity;

import lombok.Getter;

@Getter
public class Course {
    private final int id;
    private final String name;
    private final String code;

    public Course(int id, String name, String code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }
}
