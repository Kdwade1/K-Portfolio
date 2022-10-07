package com.example.kportfolio.Repository;

import com.example.kportfolio.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
    User findByVerificationCode(String code);
    User findByEmail(String email);
}
