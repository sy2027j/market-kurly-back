package com.example.kurly.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PdOptionDTO {

    private Integer opNo;
    private Integer pdNo;
    private String name;
    private Integer price;
    private String allergy;

    @Builder
    public PdOptionDTO(Integer opNo, Integer pdNo, String name, Integer price, String allergy) {
        this.opNo = opNo;
        this.pdNo = pdNo;
        this.name = name;
        this.price = price;
        this.allergy = allergy;
    }
}
