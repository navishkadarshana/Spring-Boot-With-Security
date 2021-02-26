package lk.navishka.loginWithSecuruty.dto;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserDto {

    @NotNull
    @Size(min = 5, message = "userName have at least 9 characters ")
    private String userName;

    @NotNull
    @Email(message = "You Enter Email Valid")
    private String email;

    @NotNull
    @Size(min = 4, message = "password have at least 4 characters ")
    private String password;

    public UserDto(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
