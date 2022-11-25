package com.example.kurly.model.dto;

import lombok.*;

//import javax.validation.constraints.NotNull;

public class JwtDTO {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    //@NotNull
    @Setter
    public static class JwtRefreshReqDto {

        private String id;
        private String refreshToken;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class JwtDto {

        private String userId;
        private String userName;
        private String accessToken;
        private String refreshToken;
    }
}