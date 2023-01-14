package com.example.SoulmateService.repository;

import com.example.SoulmateService.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {
   // User findByEmail(String email);
}
