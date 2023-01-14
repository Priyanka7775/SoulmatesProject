package com.example.SoulmateService.service;

import com.example.SoulmateService.domain.User;
import com.example.SoulmateService.exception.UserAlreadyFoundException;
import com.example.SoulmateService.exception.UserNotFoundException;
import com.example.SoulmateService.proxy.UserProxy;
import com.example.SoulmateService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserProxy userProxy;

    public UserServiceImpl(UserRepository userRepository,UserProxy userProxy){
        this.userProxy=userProxy;
        this.userRepository=userRepository;
    }

    @Override
    public User addUser(User user) throws UserAlreadyFoundException {
        if(userRepository.findById(user.getEmail()).isPresent()) {
            throw new UserAlreadyFoundException();
        }
        User user1 = userRepository.save(user);
        if(!(user1.getEmail().isEmpty())){
            ResponseEntity responseEntity = userProxy.saveUser(user);
            System.out.println(responseEntity.getBody());
        }
        return user1;
    }

    @Override
    public List<User> getAllTheUser() {
        return userRepository.findAll();
    }

//    @Override
//    public List<User> getAllUserByEmail(String email) throws UserNotFoundException {
//        if(userRepository.findById(email).isEmpty()){
//            throw new UserNotFoundException();
//        }
//        return userRepository.findById(email).get().getEmail();
//    }

    @Override
    public boolean deleteUser(String email) throws UserNotFoundException {
        boolean result=false;
        if(userRepository.findById(email).isEmpty()){
            throw new UserNotFoundException();
        }
        else{
            userRepository.deleteById(email);
            return true;
        }
    }
}
