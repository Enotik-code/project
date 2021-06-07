package by.mybot.authentication.service;

import by.mybot.authentication.bean.User;
import by.mybot.authentication.bean.VerificationToken;
import by.mybot.authentication.dto.UserDto;
import by.mybot.authentication.error.UserAlreadyExistException;
import by.mybot.authentication.repository.RoleRepository;
import by.mybot.authentication.repository.UserRepository;
import by.mybot.authentication.repository.VerificationTokenRepository;
import by.mybot.authentication.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Calendar;

@Service
@Transactional
public class UserService implements IUserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private VerificationTokenRepository tokenRepository;


    public static final String TOKEN_INVALID = "invalidToken";
    public static final String TOKEN_EXPIRED = "expired";
    public static final String TOKEN_VALID = "valid";

    @Override
    public User registerNewUserAccount(UserDto userDto) throws UserAlreadyExistException {
        if (emailExists(userDto.getEmail())) {
            throw new UserAlreadyExistException("There is an account with that email address: "
                    + userDto.getEmail());
        }

        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        user.setRoles(Arrays.asList(roleRepository.findByName("ROLE_USER")));

        return repository.save(user);
    }

    @Override
    public User findUserByEmail(final String email) {
        return repository.findByEmail(email);
    }

    @Override
    public User getUser(final String verificationToken) {
        final VerificationToken token = tokenRepository.findByToken(verificationToken);
        if (token != null) {
            return token.getUser();
        }
        return null;
    }

    @Override
    public String validateVerificationToken(String token) {
        final VerificationToken verificationToken = tokenRepository.findByToken(token);
        if (verificationToken == null) {
            return TOKEN_INVALID;
        }

        final User user = verificationToken.getUser();
        final Calendar cal = Calendar.getInstance();
        if ((verificationToken.getExpiryDate()
                .getTime() - cal.getTime()
                .getTime()) <= 0) {
            tokenRepository.delete(verificationToken);
            return TOKEN_EXPIRED;
        }

        user.setActive(true);
        // tokenRepository.delete(verificationToken);
        repository.save(user);
        return TOKEN_VALID;
    }


    private boolean emailExists(String email) {
        return repository.findByEmail(email) != null;
    }
}