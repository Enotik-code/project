package by.mybot.authentication.service;


import by.mybot.authentication.bean.Role;
import by.mybot.authentication.bean.User;
import by.mybot.authentication.bean.UserRoles;
import by.mybot.authentication.repository.RoleRepository;
import by.mybot.authentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Random;

@Service
public class UserService {

    public static final Integer MAX_COUNT_OF_WRONG_ATTEMPTS = 3;
    public static final Integer DEFAULT_COUNT_OF_WRONG_ATTEMPTS = 0;
    public static final Integer DEFAULT_COUNT_OF_FREE_POINTS = 10;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User findUserByUserName(String userName) {
        return userRepository.findUserByUserName(userName);
    }

    public User saveUser(User user, Optional<UserRoles> userRoleOp) {
        UserRoles newUserRole = userRoleOp.orElseGet(() -> UserRoles.ROLE_GUEST);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Role userRole = roleRepository.findByRoleName(newUserRole);
        if (userRole == null) {
            registerUser(user);
            userRole = roleRepository.save(new Role(null, newUserRole));
        }
        user.setRoles(new HashSet<>(Arrays.asList(userRole)));
        return userRepository.save(user);
    }

    public void registerUser(User user) {
        activateUser(user);
        generateRecoveryCode(user);
        setDefaultCountsOfWrongAttempts(user);
        user.setNumberOfPoints(new BigDecimal(DEFAULT_COUNT_OF_FREE_POINTS));
    }

    public void activateUser(User user) {
        user.setActive(true);
    }

    public String getCurrentUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }

    public void generateRecoveryCode(User user) {
        Random r = new Random();
        user.setActivationCode(String.valueOf(r.nextInt((999999 - 100000) + 1) + 100000));
    }

    public Optional<User> getUserByEmail(String email) {
        return Optional.of(userRepository.findUserByEmail(email));
    }

    public void setDefaultCountsOfWrongAttempts(User user) {
        user.setCountOfWrongAttempts(DEFAULT_COUNT_OF_WRONG_ATTEMPTS);
    }

    public void minusTry(User user) {
        if (!user.isBlocked()) {
            user.setCountOfWrongAttempts(user.getCountOfWrongAttempts() + 1);
            if (user.getCountOfWrongAttempts() == MAX_COUNT_OF_WRONG_ATTEMPTS) {
                blockUser(user);
            }
        }
    }

    public void blockUser(User user) {
        user.setBlocked(true);
    }
}
