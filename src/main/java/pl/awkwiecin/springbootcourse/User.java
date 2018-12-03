package pl.awkwiecin.springbootcourse;

import lombok.Data;

@Data       //lombok -- automatickly adds getters setters and so on
public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private boolean author;
    private boolean admin;


}
