package by.mybot.controller.admin;

import by.mybot.consts.Pages;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class AdminController {

    @GetMapping(value = Pages.ADMIN)
    public ModelAndView getAdminPage(){
        return new ModelAndView();
    }
}
