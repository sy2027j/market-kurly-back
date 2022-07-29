package com.example.kurly.model;

import com.querydsl.jpa.HQLTemplates;
import com.querydsl.core.types.Ops;

//numberExpression.random.asc() 를 mysql에서 사용 가능하도록 튜닝한 템플릿
public class MysqlJpaTemplates extends HQLTemplates {

    public static final MysqlJpaTemplates DEFAULT = new MysqlJpaTemplates();

    protected MysqlJpaTemplates() {
        this(DEFAULT_ESCAPE);
        add(Ops.MathOps.RANDOM, "rand()");
        add(Ops.MathOps.RANDOM2, "rand({0})");
    }

    public MysqlJpaTemplates(char escape) {
        super(escape);
    }
}
