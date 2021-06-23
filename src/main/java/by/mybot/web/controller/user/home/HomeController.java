package by.mybot.web.controller.user.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping(value = "/")
    public ModelAndView getHomePage(){
        ModelAndView modelAndView = new ModelAndView("/templates/home.html");
        return modelAndView;
    }

}
