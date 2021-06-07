package by.mybot.authentication.repository;
import by.mybot.authentication.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByEmail(String email);
    List<User> findUserByActiveFalse();
    List<User> findUserByActiveTrue();
    User findByEmail(String email);
    User findUserByUserName(String userName);
    void deleteById(Long id);
}
