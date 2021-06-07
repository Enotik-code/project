package by.mybot.controller.user.rest;

import by.mybot.authentication.bean.User;
import by.mybot.authentication.dto.UserDto;
import by.mybot.authentication.error.UserAlreadyExistException;
import by.mybot.authentication.service.UserService;
import by.mybot.utils.GenericResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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

@RestController
public class RegistrationRestController {
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @GetMapping("/user/registration")
    public String showRegistrationForm(WebRequest request, Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "registration";
    }


    @PostMapping("/user/registration")
    public GenericResponse registerUserAccount(@Valid final UserDto accountDto, final HttpServletRequest request) {
        LOGGER.debug("Registering user account with information: {}", accountDto);
        final User registered = userService.registerNewUserAccount(accountDto);
        return new GenericResponse("success");
    }

}
