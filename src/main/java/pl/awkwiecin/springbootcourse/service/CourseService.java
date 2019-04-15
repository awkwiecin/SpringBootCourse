package pl.awkwiecin.springbootcourse.service;

import pl.awkwiecin.springbootcourse.model.CourseDTO;
import pl.awkwiecin.springbootcourse.persistence.model.Course;
import pl.awkwiecin.springbootcourse.persistence.repository.CourseRepo;

import java.util.List;

public interface CourseService extends BaseService<Course, Long, CourseRepo> {

    CourseDTO getCourseDtoById(Long id);

}
