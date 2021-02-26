package lk.navishka.loginWithSecuruty.entity;

import lombok.*;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity
public class User {

    @Id
    @Column(nullable = false,unique = true,length = 10)
    private String userName;

    @Column(nullable = false,unique = true,length = 50)
    private String email;

    @Column(nullable = false)
    private String password;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Customer customer;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
