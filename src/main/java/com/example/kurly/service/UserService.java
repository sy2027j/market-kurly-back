package com.example.kurly.service;

import com.example.kurly.config.security.JwtTokenProvider;
import com.example.kurly.exception.DuplicateUserException;
import com.example.kurly.exception.NoSuchDataException;
import com.example.kurly.model.dto.UserDTO;
import com.example.kurly.model.entity.User;
import com.example.kurly.repository.UserJpaRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static com.example.kurly.model.dto.JwtDTO.*;

@RequiredArgsConstructor
@Service
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserJpaRepo userJpaRepo;

    /**
     * signUp
     *
     * @param userSignUpReqDto
     * @return User
     */
    public User signUp(UserDTO userSignUpReqDto) {
        checkDuplicateUser(userSignUpReqDto.getId()); //중복 가입 체크
        User user = userJpaRepo.save(buildUserFromUserJoinDto(userSignUpReqDto));

        return user;
    }

    private void checkDuplicateUser(String email) {
        userJpaRepo.findById(email)
                .ifPresent(param -> {
                    throw new DuplicateUserException("id = " + email);
                });
    }

    /**
     * signIn
     *
     * @param userSignInReqDto
     * @return JwtDto
     */
    public JwtDto signIn(UserDTO userSignInReqDto) { //로그인 시 여기로
        User user = userJpaRepo.findById(userSignInReqDto.getId()) //userJpaRepo.findById로 입력한 아이디와 일치하는 비밀번호 찾기
                .orElseThrow(() -> new NoSuchDataException("id = " + userSignInReqDto.getId()));
        if (!passwordEncoder.matches(userSignInReqDto.getPassword(), user.getPassword()))
            throw new NoSuchDataException("password = " + userSignInReqDto.getPassword()); //아이디와 비밀번호 일치
        String[] jwtTokens = createJwtTokens(user, user.getRoles()); //토큰 생성
        return buildJwtDto(user, jwtTokens);
    }

    private String[] createJwtTokens(User user, List<String> roles) {
        String accessToken = jwtTokenProvider.createToken(user.getUsername(), roles); //access 토큰 생성
        String refreshTokenValue = UUID.randomUUID().toString().replace("-", ""); //refresh token 중 db에 저장할 value 생성
        saveRefreshTokenValue(user, refreshTokenValue); //refresh token value db에 저장
        String refreshToken = jwtTokenProvider.createRefreshToken(refreshTokenValue); //refresh 토큰 생성
        return new String[]{accessToken, refreshToken};
    }

    private void saveRefreshTokenValue(User user, String refreshToken) { //사용자의 refreshToken 데베에 저장
        user.setRefreshTokenValue(refreshToken); //refresh token value를 set 사용자 정보로
        userJpaRepo.save(user);
    }

    /**
     * refreshToken
     *
     * @param jwtRefreshReqDto
     * @return JwtDto
     */
    public JwtDto refreshUserTokens(JwtRefreshReqDto jwtRefreshReqDto) {
        User user = userJpaRepo.findById(jwtRefreshReqDto.getId())
                .orElseThrow(() -> new NoSuchDataException("email = " + jwtRefreshReqDto.getId())); //id로 회원 찾기
        checkIfRefreshTokenValid(user.getRefreshTokenValue(), jwtRefreshReqDto.getRefreshToken()); //유저의 실제 토큰과 클라이언트에서 넘어온 토큰 비교
        String[] jwtTokens = createJwtTokens(user, user.getRoles()); //일치하면 토큰 재발급
        return buildJwtDto(user, jwtTokens);
    }

    private void checkIfRefreshTokenValid(String requiredValue, String givenRefreshToken) { //(db토큰, 클라이언트토큰) 유효한지 확인
        String givenValue = String.valueOf(jwtTokenProvider.getClaimsFromJwtToken(givenRefreshToken).get("value")); //클라이언트 토큰에서 정보 추출
        System.err.println("given : " + givenValue);
        System.err.println("required : " + requiredValue);
        if (!givenValue.equals(requiredValue)) { //db토큰과 일치 확인
            throw new DuplicateUserException("asdf");
        }
    }

    private User buildUserFromUserJoinDto(UserDTO userSignUpReqDto) {
        return User.builder()
                .email(userSignUpReqDto.getEmail())
                .password(passwordEncoder.encode(userSignUpReqDto.getPassword()))
                .name(userSignUpReqDto.getName())
                .roles(Collections.singletonList("ROLE_USER"))
                .build();
    }

    private JwtDto buildJwtDto(User user, String[] jwtTokens) {
        return JwtDto.builder()
                .userId(user.getUid())
                .userName(user.getName())
                .accessToken(jwtTokens[0])
                .refreshToken(jwtTokens[1])
                .build();
    }
}
