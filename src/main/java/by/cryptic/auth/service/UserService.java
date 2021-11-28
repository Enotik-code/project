package by.cryptic.auth.service;

import by.cryptic.auth.repos.UserRepository;
import by.cryptic.auth.repos.UserRoleRepository;
import by.cryptic.entities.User;
import by.cryptic.entities.UserRole;
import by.cryptic.models.enums.Role;
import com.google.common.hash.Hashing;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Slf4j
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User findUserByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    public User saveUser(User user) {
        Role currentRole = Role.ROLE_USER;

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setSalt(getSalt(user.getLogin()));
        User savedUser = userRepository.save(user);

        UserRole userRole = UserRole.builder()
                .role(currentRole.name())
                .userId(savedUser.getId())
                .build();

        roleRepository.save(userRole);

        return savedUser;
    }


    public String getCurrentUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }

    public String getSalt(String login){
        return Hashing.sha256()
                .hashString(login, StandardCharsets.UTF_8)
                .toString();
    }
}
