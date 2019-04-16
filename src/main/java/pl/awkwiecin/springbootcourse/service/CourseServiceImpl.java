package pl.awkwiecin.springbootcourse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.awkwiecin.springbootcourse.model.CourseDTO;
import pl.awkwiecin.springbootcourse.persistence.model.Course;
import pl.awkwiecin.springbootcourse.persistence.repository.CourseRepo;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl extends BaseServiceImpl<Course, Long, CourseRepo> implements CourseService {

    @Autowired
    private CourseRepo courseRepo;

    @Override
    public CourseRepo getRepository() {return courseRepo;}

    @Override
    public CourseDTO getCourseDtoById(Long id) {return Mapper.courseToDTO(getOne(id));}

    @Override
    public CourseDTO createCourse(CourseDTO courseDTO) {

        Course c =save(Mapper.dtoToCourse(courseDTO));
        return Mapper.courseToDTO(c);

    }

    @Override
    public List<CourseDTO> getAllCourses() {
        return getAll().stream()
                .map(Mapper::courseToDTO)
                .collect(Collectors.toList());
    }
}
