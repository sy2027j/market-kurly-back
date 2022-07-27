package com.example.kurly.controller;

import com.example.kurly.model.Product;
import com.example.kurly.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class KurlyController {

    private final ProductService service;

    @GetMapping(value="/test")
    public String pdSelect(int no){
        return "이거";
    }

    @GetMapping(value="/select/{no}")
    public Optional<Product> getProduct(@PathVariable int no) throws Exception{
        Optional<Product> product = service.getProduct(no);
        return product;
    }

    @GetMapping(value="/select")
    public List<Product> getAllProduct() throws Exception{
        List<Product> product = service.findAllInnerFetchJoin();
        return product;
    }

}
