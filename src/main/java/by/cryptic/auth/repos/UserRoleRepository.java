package by.cryptic.auth.repos;

import by.cryptic.entities.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Long > {
    UserRole findByUserId(Long userId);
}
