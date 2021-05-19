package by.mybot.controller.user.rest;

import by.mybot.authentication.bean.User;
import by.mybot.authentication.service.UserService;
import by.mybot.consts.Errors;
import by.mybot.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("/rest/api/v1/user")
public class SignController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/get/{email}")
    public ResponseEntity<?> getUser(@PathVariable("email") String email) {
        try {
            User user = userService.getUserByEmail(email).orElseThrow(() -> new UserNotFoundException(Errors.USER_NOT_FOUND));
            return ResponseEntity.ok(user);
        }
        catch (UserNotFoundException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

}
