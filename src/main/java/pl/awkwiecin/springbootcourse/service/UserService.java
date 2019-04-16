package pl.awkwiecin.springbootcourse.service;

import pl.awkwiecin.springbootcourse.model.UserDTO;
import pl.awkwiecin.springbootcourse.persistence.model.User;
import pl.awkwiecin.springbootcourse.persistence.repository.UserRepo;

public interface UserService extends BaseService<User, Long, UserRepo>{

    public UserDTO createUser(UserDTO userDTO);
    public UserDTO editUser(UserDTO userDTO);

}
