package com.example.soulmateAuth.service;

import com.example.soulmateAuth.domain.User;
import com.example.soulmateAuth.exception.UserAlreadyFoundException;
import com.example.soulmateAuth.exception.UserNotFoundException;
import com.example.soulmateAuth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    public UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    @Override
    public User saveUser(User user) throws UserAlreadyFoundException {
        if(userRepository.findById(user.getEmail()).isPresent()){
            throw new UserAlreadyFoundException();
        }
        return userRepository.save(user);
    }

    @Override
    public User getUserByEmailAndPassword(String email, String password) throws UserNotFoundException {
        User user=userRepository.findByEmailAndPassword(email, password);
        if (user==null){
            throw new UserNotFoundException();
        }
        return user;
    }
}
