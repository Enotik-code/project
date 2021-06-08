package by.mybot.authentication.service.interfaces;


import by.mybot.authentication.bean.User;
import by.mybot.authentication.dto.UserDto;

public interface IUserService {
    User registerNewUserAccount(UserDto accountDto);
}
