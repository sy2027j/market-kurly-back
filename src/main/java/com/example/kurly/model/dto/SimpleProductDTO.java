package com.example.kurly.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
public class SimpleProductDTO {

    private Integer no;
    private String name;
    private String img;
    private Integer price;
    private Integer discount;
    private Integer count;
    private Integer NPrice;

    @Builder
    public SimpleProductDTO(Integer no, String name, String img, Integer price, Integer discount, Integer count) {
        this.no = no;
        this.name = name;
        this.img = img;
        this.price = price;
        this.discount = discount;
        this.count = count;
        this.NPrice = (int)Math.floor(price*(0.01*(100-discount)));
    }

}
