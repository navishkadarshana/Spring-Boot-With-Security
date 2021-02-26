package lk.navishka.loginWithSecuruty.controller;


import lk.navishka.loginWithSecuruty.dto.CustomerDto;
import lk.navishka.loginWithSecuruty.entity.Customer;
import lk.navishka.loginWithSecuruty.service.CustomerService;
import lk.navishka.loginWithSecuruty.util.StandradResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @RequestMapping(value = {"/register"})
    public ResponseEntity saveCustomer(@Valid @RequestBody CustomerDto customer){
        customerService.saveCustomer(customer);
        StandradResponse success = new StandradResponse(200, "success", null);
        return new ResponseEntity(success, HttpStatus.OK);
    }


    @RequestMapping(value = {"/home"})
    public ResponseEntity home(){

        StandradResponse success = new StandradResponse(200, "success", "Hello");
        return new ResponseEntity(success, HttpStatus.OK);
    }
}
