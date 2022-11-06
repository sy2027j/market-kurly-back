package com.example.kurly.config.security;


import com.example.kurly.exception.DuplicateUserException;
import com.example.kurly.exception.NoSuchDataException;
import com.example.kurly.model.dto.JwtDTO;
import com.example.kurly.model.entity.User;
import com.example.kurly.repository.UserJpaRepo;
import com.example.kurly.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

public class JwtAuthenticationFilter extends GenericFilterBean {

    private JwtTokenProvider jwtTokenProvider;
    private final UserService userSer;
    private final UserJpaRepo userJpaRepo;

    // Jwt Provier 주입
    public JwtAuthenticationFilter(JwtTokenProvider jwtTokenProvider, UserService userSer, UserJpaRepo userJpaRepo) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.userSer = userSer;
        this.userJpaRepo = userJpaRepo;
    }

    // Request로 들어오는 Jwt Token의 유효성을 검증(jwtTokenProvider.validateToken)하는 filter를 filterChain에 등록합니다.
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        //헤더에서 jwt 받아오기
        String token = jwtTokenProvider.resolveToken((HttpServletRequest) request);

        try{
            if (token != null && jwtTokenProvider.validateToken(token)) {
                Authentication auth = jwtTokenProvider.getAuthentication(token);
                SecurityContextHolder.getContext().setAuthentication(auth);
            }else {
                throw new NoSuchDataException("expired");
            }
        }catch(NoSuchDataException e){
            request.setAttribute("exception", "expired");
        }

        filterChain.doFilter(request, response);
    }
}