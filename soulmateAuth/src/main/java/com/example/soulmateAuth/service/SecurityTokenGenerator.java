package com.example.soulmateAuth.service;

import com.example.soulmateAuth.domain.User;

import java.util.Map;

public interface SecurityTokenGenerator {
    Map<String,String> generateToken(User user);
}
