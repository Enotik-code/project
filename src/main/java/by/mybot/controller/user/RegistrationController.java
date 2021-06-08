package by.mybot.controller.user;

import by.mybot.authentication.bean.User;
import by.mybot.authentication.dto.UserDto;
import by.mybot.authentication.error.UserAlreadyExistException;
import by.mybot.authentication.service.MyUserDetailService;
import by.mybot.authentication.service.UserService;
import by.mybot.utils.GenericResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.Optional;
import java.util.UUID;

@Controller
public class RegistrationController {
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    public RegistrationController() {
        super();
    }

    @Autowired
    private UserService userService;

    @GetMapping("/user/registration")
    public String showRegistrationForm(WebRequest request, Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "registration";
    }

    @PostMapping("/user/registration")
    public ModelAndView registerUserAccount(@ModelAttribute("user") @Valid UserDto userDto, HttpServletRequest request, Errors errors) {
        LOGGER.debug("Registering user account with information: {}", userDto);
        ModelAndView modelAndView = new ModelAndView("/user/registration");
        try {
            User registered = userService.registerNewUserAccount(userDto);
        } catch (UserAlreadyExistException uaeEx) {
            modelAndView.addObject("message", "An account for that username/email already exists.");
            return modelAndView;
        }
        return new ModelAndView("/", "user", userDto);
    }

}
