package com.example.kurly.controller;

import com.example.kurly.config.security.JwtTokenProvider;
import com.example.kurly.exception.CEmailSigninFailedException;
import com.example.kurly.model.dto.UserDTO;
import com.example.kurly.model.entity.User;
import com.example.kurly.repository.UserJpaRepo;
import com.example.kurly.response.CommonResult;
import com.example.kurly.response.SingleResult;
import com.example.kurly.service.ResponseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Collections;

@Api(tags = {"1. Sign"})
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api")
public class SignController {

    private final UserJpaRepo userJpaRepo;
    private final JwtTokenProvider jwtTokenProvider;
    private final ResponseService responseService;
    private final PasswordEncoder passwordEncoder;

    @ApiOperation(value = "로그인", notes = "회원 로그인을 한다.")
    @PostMapping(value = "/signin")
    public SingleResult<String> signin(@ApiParam(value = "회원ID", required = true) @RequestParam String id,
                                       @ApiParam(value = "비밀번호", required = true) @RequestParam String password,
                                       HttpServletResponse response) {
        User user = userJpaRepo.findByUid(id).orElseThrow(CEmailSigninFailedException::new);
        if (!passwordEncoder.matches(password, user.getPassword())){
            throw new CEmailSigninFailedException();
        }

        String token = jwtTokenProvider.createToken(String.valueOf(user.getNo()), user.getRoles());
        System.err.println(token);

        return responseService.getSingleResult(token);

    }

    @ApiOperation(value = "가입", notes = "회원가입을 한다.")
    @PostMapping(value = "/signup")
    public CommonResult signin(UserDTO user) {
        userJpaRepo.save(User.builder()
                .uid(user.getId())
                .password(passwordEncoder.encode(user.getPassword()))
                .name(user.getName())
                .email(user.getEmail())
                .phone(user.getPhone())
                .addr(user.getAddr())
                .addrDetail(user.getAddrDetail())
                .zipcode(user.getZipcode())
                .gender(user.getGender())
                .year(user.getYear())
                .month(user.getMonth())
                .day(user.getDay())
                .roles(Collections.singletonList("ROLE_USER"))
                .build());
        return responseService.getSuccessResult();
    }

    //test
    @ApiOperation(value = "로그인 확인", notes = "로그인 상태를 확인한다.")
    @PostMapping(value = "/user/loginCheck")
    public CommonResult loginCheck() {
        return responseService.getSuccessResult();
    }
}