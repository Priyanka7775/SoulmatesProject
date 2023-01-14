package com.example.soulmateAuth.service;

import com.example.soulmateAuth.domain.User;
import com.example.soulmateAuth.exception.UserAlreadyFoundException;
import com.example.soulmateAuth.exception.UserNotFoundException;

public interface UserService {
    public User saveUser(User user) throws UserAlreadyFoundException;
    public User getUserByEmailAndPassword (String email,String password) throws UserNotFoundException;
}
