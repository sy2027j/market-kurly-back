package com.example.kurly.repository;

import com.example.kurly.model.dto.CartUserDTO;
import com.example.kurly.model.dto.UserDTO;
import com.example.kurly.model.entity.*;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CartRepositoryCustomImpl implements CartRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;
    private final JPAQuery<Cart> jpaQuery;

    public CartRepositoryCustomImpl(JPAQueryFactory jpaQueryFactory, JPAQuery<Cart> jpaQuery) {
        this.jpaQueryFactory = jpaQueryFactory;
        this.jpaQuery=jpaQuery;
    }

    @Override
    public List<CartUserDTO> findUserCartList(UserDTO dto) {
        QCart qCart = QCart.cart;
        QProduct qProduct = QProduct.product;
        QProductOption qOption = QProductOption.productOption;

        return jpaQuery.select(Projections.bean(CartUserDTO.class, qCart.count, qProduct.pdName, qOption.opName))
                .from(qCart)
                .leftJoin(qProduct).on(qCart.pdNo.eq(qProduct.no))
                .leftJoin(qOption).on(qCart.opNo.eq(qOption.opNo))
                .where(qCart.userId.eq(dto.getId()))
                .orderBy(qCart.regDtm.desc())
                .fetch();
    }
}
