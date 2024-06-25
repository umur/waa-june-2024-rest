package waa.lab2_restservice.repository;

import org.springframework.boot.web.embedded.undertow.ConfigurableUndertowWebServerFactory;
import org.springframework.stereotype.Repository;
import waa.lab2_restservice.entity.Course;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepository {
    List<Course> courses = new ArrayList<>();
    public void save(Course course){
        courses.add(course);
    }

    public Course getById(int id){
        for(Course course:courses){
            if(course.getId() == id){
                return course;
            }
        }
        return null;
    }

    public List<Course> getAll(){
        return courses;
    }

    public Course updateById(int id,Course course){
        int index = -1;
        for(int i=0;i< courses.size();i++){
            if(courses.get(i).getId()==id){
                index = i;
                break;
            }
        }
        if(index>-1){
            course.setId(id);
            courses.set(index,course);
            return course;
        }else{
            return null;
        }

    }
    public boolean deleteById(int id){
        for(int i=0;i<courses.size();i++){
            if(courses.get(i).getId()==id){
                courses.remove(i);
                return true;
            }
        }
        return false;
    }
}
