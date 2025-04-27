package com.example.jwtAuth.contoller.publicEndpoint;

import com.example.jwtAuth.model.User;
import com.example.jwtAuth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;

@RestController
public class UserController {

    @Autowired
    private UserService service;

   @PostMapping("/login")
    public String login(@RequestBody User user){


       return  service.verify(user);

    }


    @PostMapping("/register")
    public User register(@RequestBody User user){

       return service.save(user);
    }

    public void setService(UserService userService) {
       this.service = service;
    }
}
