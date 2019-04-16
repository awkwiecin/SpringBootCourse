package pl.awkwiecin.springbootcourse.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
//@AllArgsConstructor //konstruktor
public class CourseDTO {

    private String name;
    private Long id;

}
