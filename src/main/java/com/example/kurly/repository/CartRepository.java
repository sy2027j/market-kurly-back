package com.example.kurly.repository;

import com.example.kurly.model.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Integer>, CartRepositoryCustom {
}
