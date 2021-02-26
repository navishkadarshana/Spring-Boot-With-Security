package lk.navishka.loginWithSecuruty.repo;

import lk.navishka.loginWithSecuruty.entity.Customer;
import lk.navishka.loginWithSecuruty.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,String> {
    User findUserByUserName(String userName);
}
