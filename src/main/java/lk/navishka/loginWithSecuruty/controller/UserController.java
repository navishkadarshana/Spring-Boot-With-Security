package lk.navishka.loginWithSecuruty.controller;

import lk.navishka.loginWithSecuruty.dto.AuthenticationResponse;
import lk.navishka.loginWithSecuruty.dto.UserDto;
import lk.navishka.loginWithSecuruty.service.ServiceImpl.UserServiceImpl;
import lk.navishka.loginWithSecuruty.util.JwtUtil;
import lk.navishka.loginWithSecuruty.util.StandradResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserServiceImpl userService;

    @Autowired
    JwtUtil jwtUtil;

    @RequestMapping(value = "authenticate", method = RequestMethod.POST)
    public ResponseEntity createAuthenticationToken(@RequestBody UserDto userDto) throws Exception{
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userDto.getUserName(),userDto.getPassword())
            );
        }catch (BadCredentialsException e){
            throw new Exception("Incorrect userName or Password");
        }

        final UserDetails userDetails= userService.loadUserByUsername(userDto.getUserName());
        final String jwt = jwtUtil.generateToken(userDetails);

        StandradResponse response = new StandradResponse(200, "success", new AuthenticationResponse(jwt));
        return new ResponseEntity(response, HttpStatus.OK);

    }
}


