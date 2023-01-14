package com.example.SoulmateService.controller;

import com.example.SoulmateService.domain.User;
import com.example.SoulmateService.exception.UserAlreadyFoundException;
import com.example.SoulmateService.exception.UserNotFoundException;
import com.example.SoulmateService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userDetail")
public class UserController {
    @Autowired
    private UserService userService;

    public UserController(UserService userService){
        this.userService=userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> addUser(@RequestBody User user) throws UserAlreadyFoundException {
        ResponseEntity responseEntity=null;
        try{
           // User createdUser = userService.addUser(user);
          //  return new ResponseEntity(createdUser , HttpStatus.CREATED);
           // user.setSongList(new ArrayList<>());
            responseEntity=new ResponseEntity<>(userService.addUser(user), HttpStatus.CREATED);
        }catch (UserAlreadyFoundException e){
            throw new UserAlreadyFoundException();
        }catch (Exception e){
            responseEntity=new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @GetMapping("/userList")
    public ResponseEntity<?>getAllSong(){
        List<User> userList=userService.getAllTheUser();
        return new ResponseEntity<>(userList,HttpStatus.OK);
    }

    @DeleteMapping("/userdata/{email}")
    public ResponseEntity<?> deleteUser(@PathVariable String email) throws UserNotFoundException {
        ResponseEntity responseEntity = null;
        try{
            userService.deleteUser(email);
            responseEntity = new ResponseEntity("Successfully Deleted",HttpStatus.OK);
        }catch (UserNotFoundException userNotFoundException){
            throw new UserNotFoundException();
        }catch (Exception exception){
            responseEntity=new ResponseEntity(exception.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }


}
