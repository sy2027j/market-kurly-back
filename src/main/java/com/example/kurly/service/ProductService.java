package com.example.kurly.service;

import com.example.kurly.model.Product;
import com.example.kurly.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repo;

    public Optional<Product> getProduct(int no) {
        return repo.findById(no);
    }

    public List<Product> findAllInnerFetchJoin() {
        return repo.findAllInnerFetchJoin();
    }
}
