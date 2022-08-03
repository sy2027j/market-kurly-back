package com.example.kurly.service;

import com.example.kurly.model.dto.ProductDTO;
import com.example.kurly.model.dto.SimpleProductDTO;
import com.example.kurly.model.entity.Product;
import com.example.kurly.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repo;

    public SimpleProductDTO getProduct(int no) {
        return repo.findById(no).orElseThrow(()-> new NullPointerException()).MainList();
    }

    public List<SimpleProductDTO> findAllInnerFetchJoin() {
        List<SimpleProductDTO> dto = new ArrayList<>();
        List<Product> list = repo.findAllInnerFetchJoin();
        for(int i=0; i<list.size(); i++){
            dto.add(list.get(i).MainList());
        }
        return dto;
    }

    public List<SimpleProductDTO> findBestProduct(){
        List<SimpleProductDTO> dto = new ArrayList<>();
        List<Product> list = repo.findTop20ByOrderByCountDesc();
        for(int i=0; i<list.size(); i++){
            dto.add(list.get(i).MainList());
        }
        return dto;
    }

    public List<SimpleProductDTO> findHighDiscountProduct(){
        List<SimpleProductDTO> dto = new ArrayList<>();
        List<Product> list = repo.findTop20ByOrderByDiscount();
        for(int i=0; i<list.size(); i++){
            dto.add(list.get(i).MainList());
        }
        return dto;
    }
}
