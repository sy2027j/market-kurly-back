package com.example.kurly.config;

import com.example.kurly.model.MysqlJpaTemplates;
import com.example.kurly.model.entity.Product;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Configuration
public class QuerydslConfig {

    @PersistenceContext
    private EntityManager entityManager;

    @Bean
    public JPAQueryFactory jpaQueryFactory() {
        return new JPAQueryFactory(entityManager);
    }

    @Bean
    public JPAQuery<Product> jpaQueryFactory2() {
        return new JPAQuery<>(entityManager, MysqlJpaTemplates.DEFAULT);
    }
}
