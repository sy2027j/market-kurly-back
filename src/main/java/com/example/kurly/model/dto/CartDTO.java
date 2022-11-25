package com.example.kurly.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartDTO {

    private Integer cartNo;
    private String userId;
    private Integer pdNo;
    private Integer opNo;
    private Integer count;
}
