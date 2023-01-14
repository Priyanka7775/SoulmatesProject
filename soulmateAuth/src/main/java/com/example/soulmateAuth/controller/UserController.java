package com.example.soulmateAuth.controller;

import com.example.soulmateAuth.domain.User;
import com.example.soulmateAuth.exception.UserAlreadyFoundException;
import com.example.soulmateAuth.exception.UserNotFoundException;
import com.example.soulmateAuth.service.SecurityTokenGenerator;
import com.example.soulmateAuth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private SecurityTokenGenerator securityTokenGenerator;

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) throws UserNotFoundException {
        Map<String,String> map=null;
        try{
            User user1=userService.getUserByEmailAndPassword(user.getEmail(), user.getPassword());
            if(user1.getEmail().equals(user.getEmail())){
                map=securityTokenGenerator.generateToken(user);
            }
            return new ResponseEntity<>(map, HttpStatus.OK);
        }catch (UserNotFoundException e){
            throw new RuntimeException(e);
        }catch (Exception e){
            return new ResponseEntity<>("Try after sometimes", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> saveUser(@RequestBody User user)throws UserAlreadyFoundException {
        User userCreated=userService.saveUser(user);
        return new ResponseEntity<>(userCreated, HttpStatus.CREATED);
    }
}
