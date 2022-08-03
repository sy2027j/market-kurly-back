package com.example.kurly.repository;

import com.example.kurly.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer>, ProductRepositoryCustom {
    List<Product> findTop20ByOrderByCountDesc();
    List<Product> findTop20ByOrderByDiscount();
}
