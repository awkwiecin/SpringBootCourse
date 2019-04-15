package pl.awkwiecin.springbootcourse.persistence.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "courses") //adnotacja do tabeli courses
public class Course extends BaseEntity {

    @Column(name = "name")
    private String name;
}

