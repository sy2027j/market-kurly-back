package com.example.kurly.repository;

import com.example.kurly.model.entity.Product;
import com.example.kurly.model.entity.QProduct;
import com.querydsl.core.types.dsl.NumberExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepositoryCustomImpl implements ProductRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;
    private final JPAQuery<Product> jpaQuery;

    public ProductRepositoryCustomImpl(JPAQueryFactory jpaQueryFactory, JPAQuery<Product> jpaQuery) {
        this.jpaQueryFactory = jpaQueryFactory;
        this.jpaQuery=jpaQuery;
    }

    @Override
    public List<Product> findAllInnerFetchJoin() {
        int count = 4;
        QProduct product = QProduct.product;

        System.err.println(jpaQuery);

        return jpaQuery
                .select(product)
                .from(product)
                .orderBy(NumberExpression.random().asc())
                .limit(count)
                .fetch();
    }
}
