package pl.awkwiecin.springbootcourse.service;

import pl.awkwiecin.springbootcourse.model.CourseDTO;
import pl.awkwiecin.springbootcourse.persistence.model.Course;

public class Mapper {
    public static CourseDTO courseToDTO(Course course) {
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setId(course.getId());
        courseDTO.setName(course.getName());
        courseDTO.setLengthInSecond(0);
        return courseDTO;
    }

    public static Course dtoToCourse(CourseDTO courseDTO) {
        Course course = new Course();
        course.setId(courseDTO.getId());
        course.setName(courseDTO.getName());
        return course;
    }
}
