package by.mybot.controller.user;

import by.mybot.consts.Pages;
import by.mybot.consts.Paths;
import by.mybot.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class IndexController {

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
    public ModelAndView postSignInPage(@RequestParam(value = "exampleInputEmail1") String username, @RequestParam(value = "exampleInputPassword1") String password){
        ModelAndView modelAndView = new ModelAndView(Paths.SIGN_IN_PAGE);

        User newUser =  User.builder().login(username).password(password.toCharArray()).build();
        System.out.println(newUser);
        return modelAndView;
    }

    @GetMapping(value = Pages.SIGN_IN)
    public ModelAndView getSignInPage(){
        return new ModelAndView(Paths.SIGN_IN_PAGE);
    }
}
