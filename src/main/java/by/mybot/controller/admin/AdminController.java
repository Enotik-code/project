package by.mybot.controller.admin;

import by.mybot.authentication.bean.User;
import by.mybot.authentication.repository.UserRepository;
import by.mybot.consts.Pages;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class AdminController {

    private final UserRepository userRepository;

    @GetMapping(value = Pages.ADMIN)
    public ModelAndView getAdminPage(){
        return new ModelAndView();
    }

    @GetMapping(value = "users")
    public ModelAndView getUser(){
        ModelAndView modelAndView = new ModelAndView("/admin/usersList.html");
        List<User> userList = userRepository.findAll();
        modelAndView.addObject("count", userList.size());
        modelAndView.addObject("users", userList);
        return modelAndView;
    }
}
