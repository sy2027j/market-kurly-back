package com.example.kurly.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CartDTO {

    private Integer cartNo;
    private String userId;
    private Integer pdNo;
    private Integer opNo;
    private Integer count;

    @Builder
    public CartDTO(Integer cartNo, String userId, Integer pdNo, Integer opNo, Integer count) {
        this.cartNo = cartNo;
        this.userId = userId;
        this.pdNo = pdNo;
        this.opNo = opNo;
        this.count = count;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    public class UserCartDTO{
        private Integer count;
        private String pdName;
        private String opName;
    }
}
