package by.mybot.web.controller.user.home;

import by.mybot.service.locations.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping(value = "/home")
    public ModelAndView getHomePage(){
        ModelAndView modelAndView = new ModelAndView("/home.html");
        return modelAndView;
    }

}
