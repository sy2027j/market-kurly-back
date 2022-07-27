package com.example.kurly.repository;

import com.example.kurly.model.Product;

import java.util.List;

public interface ProductRepositoryCustom {
    List<Product> findAllInnerFetchJoin();
}
