package cs544.lab2.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Course {
    private long id;
    private String name;
    private String code;

//    public Course(long id, String name, String code) {
//        this.id = id;
//        this.name = name;
//        this.code = code;
//    }
}
