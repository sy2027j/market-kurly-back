package com.example.kurly.model.entity;

import com.example.kurly.model.dto.PdOptionDTO;
import lombok.Getter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "product_option")
@DynamicInsert
@DynamicUpdate
@Getter
public class ProductOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "op_no")
    private Integer opNo;

    @Column(name = "pd_no")
    private Integer pdNo;

    @Column(name = "op_name")
    private String name;

    @Column(name = "op_price")
    private Integer price;

    @Column(name = "op_allergy")
    private String allergy;

    public PdOptionDTO optionInfo(){
        return PdOptionDTO.builder()
                .opNo(opNo)
                .pdNo(pdNo)
                .name(name)
                .price(price)
                .allergy(allergy)
                .build();
    }
}
