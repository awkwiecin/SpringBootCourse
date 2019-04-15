package pl.awkwiecin.springbootcourse.persistence.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@Data
public class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //---- Creation of table in data base --//
    @Column(name = "id")
    private Long id;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "created_date", updatable = false)
    private Date created_date;

    @Column(name = "updated_date")
    private Date updated_date;

    @PrePersist
    protected void logDataBegoreInsert() {

        this.created_date = new Date();
        this.updated_date = new Date();
        this.active = true;
    }

    @PreUpdate
    protected void logDataBeforeUpdate() {
        this.created_date = new Date();
    }

}
