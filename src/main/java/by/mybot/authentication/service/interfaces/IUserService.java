package by.mybot.authentication.service.interfaces;


import by.mybot.authentication.bean.User;
import by.mybot.authentication.dto.UserDto;

public interface IUserService {
    User registerNewUserAccount(UserDto accountDto);
    User findUserByEmail(String email);
    User getUser(String verificationToken);
    public String validateVerificationToken(String token);

}
