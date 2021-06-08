package by.mybot.authentication.dto;

import by.mybot.authentication.validation.email.ValidEmail;
import by.mybot.authentication.validation.password.PasswordMatches;
import by.mybot.authentication.validation.password.ValidPassword;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@PasswordMatches
public class UserDto {
    @NotNull
    @NotEmpty
    @Size(min = 1, message = "{Size.userDto.firstName}")
    private String firstName;

    @NotNull
    @NotEmpty
    @Size(min = 1, message = "{Size.userDto.lastName}")
    private String lastName;

    @NotNull
    @NotEmpty
    @ValidPassword
    private String password;

    @NotNull
    @Size(min = 1)
    private String matchingPassword;

    @ValidEmail
    @NotNull
    @Size(min = 1, message = "{Size.userDto.email}")
    private String email;
}
