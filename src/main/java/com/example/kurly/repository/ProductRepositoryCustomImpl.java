package com.example.kurly.repository;
import com.example.kurly.model.Product;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;
import com.example.kurly.model.QProduct;

import java.util.List;

@Repository
public class ProductRepositoryCustomImpl implements ProductRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    public ProductRepositoryCustomImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public List<Product> findAllInnerFetchJoin() {

        QProduct product = QProduct.product;
        return jpaQueryFactory.selectFrom(product)
                .fetch();
    }
}
