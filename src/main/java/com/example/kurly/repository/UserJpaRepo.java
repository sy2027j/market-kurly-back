package com.example.kurly.repository;

import com.example.kurly.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJpaRepo extends JpaRepository<User, Integer> {
    Optional<User> findByUid(String email);
}
