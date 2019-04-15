package pl.awkwiecin.springbootcourse.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
//@AllArgsConstructor //konstruktor
public class CourseDTO {

    private Long id;
    private String name;
    private int LengthInSecond;

}
