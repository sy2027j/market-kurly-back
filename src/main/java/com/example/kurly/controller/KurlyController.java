package com.example.kurly.controller;

import com.example.kurly.model.dto.ProductDTO;
import com.example.kurly.model.dto.SimpleProductDTO;
import com.example.kurly.model.entity.Product;
import com.example.kurly.response.DefaultResponse;
import com.example.kurly.response.ResponseMessage;
import com.example.kurly.response.StatusCode;
import com.example.kurly.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = {"3. Kurly"})
@RestController
@RequestMapping("/api/kurly")
@RequiredArgsConstructor //class내부의 final객체는 Constructor injection수행
public class KurlyController {

    private final ProductService service;

    @ApiOperation(value = "상품 단건 상세 조회", notes = "상품 단건 정보를 상세 조회한다")
    @GetMapping(value = "/select/{no}")
    public ResponseEntity<?> getProduct(@PathVariable int no) throws Exception {
        SimpleProductDTO res = service.getProduct(no);
        return new ResponseEntity(DefaultResponse.res(StatusCode.OK, ResponseMessage.PRODUCT_SELECT, res), HttpStatus.OK);
    }

    @ApiOperation(value = "랜덤 상품 리스트 조회", notes = "랜덤으로 4개의 상품 리스트를 조회한다")
    @GetMapping(value = "/main/random")
    public ResponseEntity<?> getRandomProduct() throws Exception {
        List<SimpleProductDTO> product = service.findAllInnerFetchJoin();
        return new ResponseEntity(DefaultResponse.res(StatusCode.OK, ResponseMessage.PRODUCT_RANDOM, product), HttpStatus.OK);
    }

    @ApiOperation(value = "베스트 상품 리스트 조회", notes = "누적 판매수가 높은 순서대로 20개의 상품 리스트를 조회한다")
    @GetMapping(value = "/main/best")
    public ResponseEntity<?> getBestProduct() throws Exception {
        List<SimpleProductDTO> product = service.findBestProduct();
        return new ResponseEntity(DefaultResponse.res(StatusCode.OK, ResponseMessage.PRODUCT_BEST, product), HttpStatus.OK);
    }

    @ApiOperation(value = "할인 상품 리스트 조회", notes = "할인률이 높은 순서대로 20개의 상품 리스트를 조회한다")
    @GetMapping(value = "/main/top50")
    public ResponseEntity<?> getHighDiscount() throws Exception {
        List<SimpleProductDTO> product = service.findHighDiscountProduct();
        return new ResponseEntity(DefaultResponse.res(StatusCode.OK, ResponseMessage.PRODUCT_HIGH_DISCOUNT, product), HttpStatus.OK);
    }

}
