package com.example.kurly.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CartUserDTO {

    private Integer count;
    private String pdName;
    private String opName;

    @Builder
    public CartUserDTO(String pdName, String opName, Integer count) {
        this.pdName = pdName;
        this.opName = opName;
        this.count = count;
    }

}
