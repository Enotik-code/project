package by.mybot.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class User {
    private Long id;
    private String login;
    private char[] password;

    private boolean isAdmin;
    private boolean isBlocked;

}
