package by.mybot.controller.user;

import by.mybot.authentication.bean.Role;
import by.mybot.authentication.bean.User;
import by.mybot.authentication.bean.UserRoles;
import by.mybot.authentication.service.UserService;
import by.mybot.consts.BCrypts;
import by.mybot.consts.Pages;
import by.mybot.consts.Paths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @Autowired
    private UserService userService;

    @GetMapping(value = Pages.INDEX)
    public ModelAndView getIndexPage(){
       ModelAndView modelAndView = new ModelAndView(Paths.INDEX_PAGE);
       modelAndView.addObject("text", "Send message" );

       return modelAndView;
    }

    @GetMapping(value = Pages.PRICING)
    public ModelAndView getPricePage(){
        return new ModelAndView(Paths.PRICE_PAGE);
    }

    @PostMapping(value = Pages.SIGN_IN)
    public ModelAndView postSignInPage(@ModelAttribute(value = "inputEmail") String email,
                                       @ModelAttribute(value = "inputPassword") String password){
        ModelAndView modelAndView = new ModelAndView(Pages.SIGN_IN);
        User newUser =  User.builder().email(email).password(BCrypts.cryptPassword(password)).build();
        userService.saveUser(newUser, java.util.Optional.of(UserRoles.ROLE_GUEST));
        return new ModelAndView(Pages.REDIRECT + Pages.INDEX);
    }

    @GetMapping(value = Pages.SIGN_IN)
    public ModelAndView getSignInPage(){
        return new ModelAndView(Paths.SIGN_IN_PAGE);
    }
}
