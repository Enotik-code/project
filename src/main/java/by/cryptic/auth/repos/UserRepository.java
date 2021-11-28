package by.cryptic.auth.repos;


import by.cryptic.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByEmail(String email);
    User findByLogin(String login);
    void deleteById(Long id);
}
