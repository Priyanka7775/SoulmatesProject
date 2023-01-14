package com.example.soulmateAuth.repository;

import com.example.soulmateAuth.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    User findByEmailAndPassword(String email, String password);
}
