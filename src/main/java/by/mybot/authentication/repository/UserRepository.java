package by.mybot.authentication.repository;
import by.mybot.authentication.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Transactional
    User findUserByEmail(String email);

    @Transactional
    List<User> findUserByActiveFalse();

    @Transactional
    List<User> findUserByActiveTrue();

    @Transactional
    User findUserByUserName(String userName);

    @Transactional
    void deleteById(Long id);
}
