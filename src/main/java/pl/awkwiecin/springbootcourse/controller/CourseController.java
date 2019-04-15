package pl.awkwiecin.springbootcourse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.awkwiecin.springbootcourse.model.CourseDTO;
import pl.awkwiecin.springbootcourse.exception.WrongIdException;
import pl.awkwiecin.springbootcourse.persistence.model.Course;
import pl.awkwiecin.springbootcourse.persistence.repository.CourseRepo;
import pl.awkwiecin.springbootcourse.service.CourseService;
import pl.awkwiecin.springbootcourse.service.Mapper;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/course")
public class CourseController {

    private List<CourseDTO> cours = new ArrayList<>();

    @Autowired
    CourseService courseService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<CourseDTO> createCourse(@RequestBody CourseDTO courseDTO) {
        if (courseDTO.getId()==null || courseDTO.getId()<0)
            throw new WrongIdException("courseDTO variable has a null id or negative id!!!");
        cours.add(courseDTO);
        System.out.println(courseDTO.getName());
        System.out.println(courseDTO.getLengthInSecond());
        return new ResponseEntity<>(courseDTO, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/available", method = RequestMethod.GET)
    public ResponseEntity<List<CourseDTO>> getAvailableCourse() {
        return new ResponseEntity<>(cours, HttpStatus.OK);
    }

    @RequestMapping(value = "/buy/{id}", method = RequestMethod.GET)
    public CourseDTO buyCourse(@PathVariable(value = "id") Long id) {
        System.out.println("buyCourse");
        Course course = new Course();
        course.setName("SBC");
        courseService.save(course);
        return null;
    }


    @RequestMapping(value = "/buy2", method = RequestMethod.POST)
    public CourseDTO buyCourse2(@RequestParam(value = "id") Long id) {
        System.out.println("buyCourse2");
        return getCourse(id);
    }

    private CourseDTO getCourse(Long id) {
        CourseDTO courseDTO = null;
        for (CourseDTO c : cours) {
            if (c.getId() != null && c.getId().equals(id)) {
                courseDTO = c;
                break;
            }
        }
        if (courseDTO == null) {
            // TODO
        }
        return courseDTO;
    }

//    @RequestMapping(value = "/bought", method = RequestMethod.GET) FIXME
//    public ResponseEntity<List<CourseDTO>> getBoughtCourse() {
//        return new ResponseEntity<>(cours, HttpStatus.CREATED);
//    }

}
