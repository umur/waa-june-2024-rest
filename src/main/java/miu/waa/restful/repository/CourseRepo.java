package miu.waa.restful.repository;

import miu.waa.restful.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseRepo extends DefaultRepository<Course> {
    {
        repo.addAll(List.of(
            new Course(101, "Foundation Programming", "CS301"),
            new Course(102, "Modern Programming Practice", "CS401"),
            new Course(103, "Modern Web Application", "CS525"),
            new Course(104, "Web Application Architect", "CS545")
        ));
    };
}
