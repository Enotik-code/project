package by.mybot.authentication.service.interfaces;


import by.mybot.authentication.bean.User;
import by.mybot.authentication.bean.VerificationToken;
import by.mybot.authentication.dto.UserDto;
import by.mybot.authentication.error.UserAlreadyExistException;

public interface IUserService {
    User registerNewUserAccount(UserDto userDto)
            throws UserAlreadyExistException;

    User getUser(String verificationToken);

    void saveRegisteredUser(User user);

    void createVerificationToken(User user, String token);

    VerificationToken getVerificationToken(String VerificationToken);

    String validateVerificationToken(String token);

    VerificationToken generateNewVerificationToken(final String existingVerificationToken);
}
