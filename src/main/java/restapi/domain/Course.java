package restapi.domain;

import lombok.Data;

@Data
public class Course {
    private Integer id;
    private String name;
    private String code;
    public Course(Integer id,  String name,  String code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }
}
