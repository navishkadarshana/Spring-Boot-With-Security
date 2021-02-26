package lk.navishka.loginWithSecuruty.service.ServiceImpl;

import lk.navishka.loginWithSecuruty.dto.CustomerDto;
import lk.navishka.loginWithSecuruty.dto.UserDto;
import lk.navishka.loginWithSecuruty.entity.Customer;
import lk.navishka.loginWithSecuruty.entity.User;
import lk.navishka.loginWithSecuruty.repo.CustomerRepo;
import lk.navishka.loginWithSecuruty.repo.UserRepo;
import lk.navishka.loginWithSecuruty.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;

@Transactional
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    ModelMapper mapper;

    @Autowired
    private PasswordEncoder passwordEncoder;



    @Override
    public void saveCustomer(CustomerDto dto) {

            if (!customerRepo.existsById(dto.getNic())){


                for (UserDto userDto : dto.getUser()){
                    if(!userRepo.existsById(userDto.getUserName())){
                        User user = mapper.map(userDto, User.class);
                        Customer customer =new Customer(dto.getNic(),dto.getAddress(),dto.getFirstName(),dto.getLastName(),user);
                        String hashedPassword = passwordEncoder.encode(user.getPassword());
                        user.setPassword(hashedPassword);
                        customerRepo.save(customer);
                        userRepo.save(user);
                    }else {
                        throw  new RuntimeException(userDto.getUserName()+" you entered userName is already exist!");
                    }

                }

            }else {
                throw  new RuntimeException(dto.getNic()+" you entered NIC is already exist!");
            }

    }
}
