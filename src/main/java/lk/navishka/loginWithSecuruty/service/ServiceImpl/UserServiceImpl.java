package lk.navishka.loginWithSecuruty.service.ServiceImpl;

import lk.navishka.loginWithSecuruty.entity.User;
import lk.navishka.loginWithSecuruty.repo.UserRepo;
import lk.navishka.loginWithSecuruty.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@Transactional
@Service
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    UserRepo  userRepo;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepo.findUserByUserName(userName);

        if (user==null){
            throw  new UsernameNotFoundException("Invalid UserName Or Password");
        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(),user.getPassword(),new ArrayList<>());

    }
}
