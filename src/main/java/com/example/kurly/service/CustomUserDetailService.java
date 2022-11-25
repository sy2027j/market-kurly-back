package com.example.kurly.service;

import com.example.kurly.exception.NoSuchDataException;
import com.example.kurly.repository.UserJpaRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomUserDetailService implements UserDetailsService {

    private final UserJpaRepo userJpaRepo;

    @Override
    public UserDetails loadUserByUsername(String userPk) {
        //return userJpaRepo.findById(userPk).orElseThrow(CUserNotFoundException::new);
        return userJpaRepo.findById(userPk)
                .orElseThrow(()-> new NoSuchDataException("userId = "+userPk));
    }
}