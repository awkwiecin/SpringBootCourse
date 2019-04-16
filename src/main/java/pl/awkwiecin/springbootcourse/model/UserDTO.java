package pl.awkwiecin.springbootcourse.model;

import lombok.Data;

@Data       //lombok -- automatickly adds getters setters and so on
public class UserDTO {
    private Long    id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private boolean author;
    private boolean admin;

}
