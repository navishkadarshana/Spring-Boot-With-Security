package lk.navishka.loginWithSecuruty.dto;


import lombok.*;

import javax.persistence.Column;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CustomerDto {

    @NotNull
    @Size(min = 9, message = "Nic have at least 9 characters ")
    private String nic;
    private String address;
    @NotNull
    @Size(min = 5, message = "FirstName have at least 5 characters ")
    private String firstName;
    @NotNull
    @Size(min = 5, message = "LastName have at least 5 characters ")
    private  String lastName;

    private List<@Valid UserDto> user = new ArrayList<>();
}
