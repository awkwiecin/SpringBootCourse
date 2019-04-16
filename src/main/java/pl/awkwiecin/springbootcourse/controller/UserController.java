package pl.awkwiecin.springbootcourse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.awkwiecin.springbootcourse.exception.WrongIdException;
import pl.awkwiecin.springbootcourse.model.UserDTO;
import pl.awkwiecin.springbootcourse.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseStatus(value = HttpStatus.CREATED)
    @RequestMapping(value = "/registry", method = RequestMethod.POST)
    public UserDTO registry (@RequestBody UserDTO userDTO){
        if (idExist(userDTO))
            throw new WrongIdException("Tworzony kurs nie powinien posiadać ID.");
        return userService.createUser(userDTO);
    }
    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    public UserDTO edit(@RequestBody UserDTO userDTO){
        if(!idExist(userDTO))
            throw new WrongIdException("Edytowany użytkownik musi posiadać id.");
        return userService.editUser(userDTO);
    }

    @RequestMapping(value = "/confirm/{id}",method = RequestMethod.PUT )
    public UserDTO confirm(@PathVariable(value = "id") Long id){
        return new UserDTO();
    }

    @RequestMapping(value = "/add", method = RequestMethod.PUT) //add by admin
    public UserDTO add(@RequestBody UserDTO userDTO){
        if(idExist(userDTO))
            throw new WrongIdException("Dodawany użytkownik nie powinien posiadać id.");
        return userService.createUser(userDTO);
    }

    private boolean idExist(UserDTO userDTO) {
        return userDTO.getId() !=null;
    }
}
