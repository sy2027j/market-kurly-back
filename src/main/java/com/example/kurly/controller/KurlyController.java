package com.example.kurly.controller;

import com.example.kurly.model.dto.ProductDTO;
import com.example.kurly.model.dto.SimpleProductDTO;
import com.example.kurly.model.entity.Product;
import com.example.kurly.response.DefaultResponse;
import com.example.kurly.response.ResponseMessage;
import com.example.kurly.response.StatusCode;
import com.example.kurly.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor //class내부의 final객체는 Constructor injection수행
public class KurlyController {

    private final ProductService service;

    //상품 단건 조회
    @GetMapping(value = "/select/{no}")
    public ResponseEntity<?> getProduct(@PathVariable int no) throws Exception {
        SimpleProductDTO res = service.getProduct(no);
        return new ResponseEntity(DefaultResponse.res(StatusCode.OK, ResponseMessage.PRODUCT_SELECT, res), HttpStatus.OK);
    }

    //상품 랜덤 조회
    @GetMapping(value = "/main/random")
    public ResponseEntity<?> getRandomProduct() throws Exception {
        List<SimpleProductDTO> product = service.findAllInnerFetchJoin();
        return new ResponseEntity(DefaultResponse.res(StatusCode.OK, ResponseMessage.PRODUCT_RANDOM, product), HttpStatus.OK);
    }

    //판매량이 높은 상품 20개 조회
    @PostMapping(value = "/main/best")
    public ResponseEntity<?> getBestProduct() throws Exception {
        List<SimpleProductDTO> product = service.findBestProduct();
        return new ResponseEntity(DefaultResponse.res(StatusCode.OK, ResponseMessage.PRODUCT_BEST, product), HttpStatus.OK);
    }

    //할인률이 높은 상품 20개 조회
    @GetMapping(value = "/main/top50")
    public ResponseEntity<?> getHighDiscount() throws Exception {
        List<SimpleProductDTO> product = service.findHighDiscountProduct();
        return new ResponseEntity(DefaultResponse.res(StatusCode.OK, ResponseMessage.PRODUCT_HIGH_DISCOUNT, product), HttpStatus.OK);
    }

}
