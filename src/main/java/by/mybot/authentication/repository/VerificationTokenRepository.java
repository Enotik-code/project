package by.mybot.authentication.repository;

import by.mybot.authentication.bean.User;
import by.mybot.authentication.bean.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerificationTokenRepository
        extends JpaRepository<VerificationToken, Long> {

    VerificationToken findByToken(String token);

    VerificationToken findByUser(User user);
}
