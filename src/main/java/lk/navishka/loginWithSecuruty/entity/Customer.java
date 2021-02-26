package lk.navishka.loginWithSecuruty.entity;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity
public class Customer {
    @Id
    @NotNull
    @Size(min = 9, message = "Nic have at least 9 characters ")
    private String nIC;

    @NotNull
    @Column(nullable = false,length = 100)
    private String address;

    @NotNull
    @Size(min = 5, message = "FirstName have at least 5 characters ")
    @Column(nullable = false,length = 30)
    private String firstName;

    @NotNull
    @Size(min = 5, message = "LastName have at least 5 characters ")
    @Column(nullable = false,length = 30)
    private  String lastName;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userName", referencedColumnName = "userName")
    private User user;
}
