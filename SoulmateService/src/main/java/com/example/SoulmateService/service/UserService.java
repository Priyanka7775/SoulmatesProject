package com.example.SoulmateService.service;

import com.example.SoulmateService.domain.User;
import com.example.SoulmateService.exception.UserAlreadyFoundException;
import com.example.SoulmateService.exception.UserNotFoundException;

import java.util.List;

public interface UserService {
    public User addUser(User user)throws UserAlreadyFoundException;
    List<User> getAllTheUser();
//    List<User> getAllUserByEmail(String email) throws UserNotFoundException;
    public boolean deleteUser(String email) throws UserNotFoundException;
}
