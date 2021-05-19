package by.mybot.authentication.bean;

import java.io.Serializable;

public enum UserRoles implements Serializable {
    ROLE_ADMIN("Has full access"),
    ROLE_GUEST("Registered, but not participate in any courses");

    private String info;

    UserRoles(String info) {
        this.info = info;
    }
}
