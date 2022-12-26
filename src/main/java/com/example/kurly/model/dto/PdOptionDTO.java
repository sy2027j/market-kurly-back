package com.example.kurly.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PdOptionDTO {

    private Integer opNo;
    private Integer pdNo;
    private String opName;
    private Integer price;
    private String allergy;

    @Builder
    public PdOptionDTO(Integer opNo, Integer pdNo, String opName, Integer price, String allergy) {
        this.opNo = opNo;
        this.pdNo = pdNo;
        this.opName = opName;
        this.price = price;
        this.allergy = allergy;
    }
}
