package com.example.kurly.repository;

import com.example.kurly.model.entity.ProductOption;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PdOptionRepository extends JpaRepository<ProductOption, Integer> {
    List<ProductOption> findByPdNo(int pdNo);
}
