package by.cryptic.auth.service;

import by.cryptic.entities.UserRole;
import by.cryptic.models.enums.Role;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserAccessService {

    public boolean isCurrentUserAuthenticated() {
        boolean isUserAuthenticated = false;
        if (SecurityContextHolder.getContext().getAuthentication() != null
                && SecurityContextHolder.getContext().getAuthentication().isAuthenticated()
                && !(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken)) {
            isUserAuthenticated = true;
        }
        return isUserAuthenticated;
    }

    public boolean isCurrentUserIsAdmin() {
        boolean isCurrentUserIsAdmin = false;
        if (isCurrentUserAuthenticated()) {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
            isCurrentUserIsAdmin = authorities.stream().anyMatch(ga -> ga.getAuthority().equals(Role.ROLE_ADMIN.name()));
        }
        return isCurrentUserIsAdmin;
    }

    public static boolean hasRole(String role) {
        return SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream()
                .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals(role));
    }
}