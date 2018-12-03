package pl.awkwiecin.springbootcourse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class Controller {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        User user = new User();
        user.setFirstName("Andrzej");
        return "Hello End User";
    }
}
