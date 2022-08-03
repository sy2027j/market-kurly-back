package com.example.kurly.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
public class ProductDTO {

    private Integer no;
    private String name;
    private String img;
    private Integer price;
    private Integer discount;
    private Integer count;
    private Integer NPrice;

    private String des;
    private String delivery;
    private String seller;
    private String packing;
    private String unit;
    private String weight;
    private String origin;
    private String deadline;
    private String notice;
    private String allergy;
    private String category;
    private String category2;
    private Integer option;
    private String tag;
    private String brand;
    private Integer recomm;

    @Builder
    public ProductDTO(Integer no, String name, String img, Integer price, Integer discount, Integer count, String des, String delivery, String seller, String packing, String unit, String weight, String origin, String deadline, String notice, String allergy, String category, String category2, Integer option, String tag, String brand, Integer recomm) {
        this.no = no;
        this.name = name;
        this.img = img;
        this.price = price;
        this.discount = discount;
        this.count = count;
        this.des = des;
        this.delivery = delivery;
        this.seller = seller;
        this.packing = packing;
        this.unit = unit;
        this.weight = weight;
        this.origin = origin;
        this.deadline = deadline;
        this.notice = notice;
        this.allergy = allergy;
        this.category = category;
        this.category2 = category2;
        this.option = option;
        this.tag = tag;
        this.brand = brand;
        this.recomm = recomm;
        this.NPrice = (int)Math.floor(price*(0.01*(100-discount)));
    }
}
