package com.example.kurly.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.sql.Date;

@Builder
@Entity
@Table(name = "cart")
@DynamicInsert
@DynamicUpdate
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_no")
    private Integer no;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "pd_no")
    private Integer pdNo;

    @Column(name = "op_no")
    private Integer opNo;

    @Column(name = "cart_count")
    private Integer count;

    @Column(name = "reg_dtm")
    private Date regDtm;

}
