package by.mybot.authentication.repository;


import by.mybot.authentication.bean.Role;
import by.mybot.authentication.bean.UserRoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRoleName(UserRoles role);
}

