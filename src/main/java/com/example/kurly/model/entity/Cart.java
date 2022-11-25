package com.example.kurly.model.entity;

import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Builder
@Entity
@Table(name = "cart")
@DynamicInsert
@DynamicUpdate
@Getter
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_no")
    private Integer no;

    @Column(name = "user_id")
    private String id;

    @Column(name = "pd_no")
    private Integer pdNo;

    @Column(name = "op_no")
    private Integer opNo;

    @Column(name = "cart_count")
    private Integer count;

    public Cart() {

    }
}
