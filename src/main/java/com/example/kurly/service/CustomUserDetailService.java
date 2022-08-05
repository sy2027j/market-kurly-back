package com.example.kurly.service;

import com.example.kurly.advice.exception.CUserNotFoundException;
import com.example.kurly.repository.UserJpaRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomUserDetailService implements UserDetailsService {

    private final UserJpaRepo userJpaRepo;

    public UserDetails loadUserByUsername(String userPk) {
        return userJpaRepo.findById(Integer.valueOf(userPk)).orElseThrow(CUserNotFoundException::new);
    }
}