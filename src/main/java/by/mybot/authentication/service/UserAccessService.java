package by.mybot.authentication.service;

import by.mybot.authentication.bean.UserRoles;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserAccessService {

    public boolean isCurrentUserAuthenticated() {
       //
        return true;
    }

    public boolean isCurrentUserIsAdmin() {
      //
        return true;
    }

    public static  boolean hasRole (UserRoles role){
       //
        return true;
    }


}
