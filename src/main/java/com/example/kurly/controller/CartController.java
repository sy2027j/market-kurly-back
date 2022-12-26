package com.example.kurly.controller;

import com.example.kurly.model.dto.CartDTO;
import com.example.kurly.model.dto.CartUserDTO;
import com.example.kurly.model.dto.UserDTO;
import com.example.kurly.model.entity.Cart;
import com.example.kurly.repository.CartRepository;
import com.example.kurly.response.DefaultResponse;
import com.example.kurly.response.ResponseMessage;
import com.example.kurly.response.StatusCode;
import com.example.kurly.service.CartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = {"4. Cart"})
@RestController
@RequestMapping("/api/kurly/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartSer;
    private final CartRepository cartRepo;

    @ApiOperation(value = "장바구니 조회", notes = "장바구니를 조회한다")
    @GetMapping
    public ResponseEntity<?> selectCart(UserDTO dto) throws Exception {
        List<CartUserDTO> cart = cartSer.selectCart(dto);
        return new ResponseEntity(DefaultResponse.res(StatusCode.OK, ResponseMessage.CART_SELECT, cart), HttpStatus.OK);
    }

    @ApiOperation(value = "장바구니 상품 담기", notes = "장바구니에 상품을 담는다")
    @PostMapping
    public ResponseEntity<?> insertCart(CartDTO cart) throws Exception {
            cartRepo.save(Cart.builder()
                    .userId(cart.getUserId())
                    .pdNo(cart.getPdNo())
                    .opNo(cart.getOpNo())
                    .count(cart.getCount())
                    .build());
        return new ResponseEntity(DefaultResponse.res(StatusCode.OK, ResponseMessage.CART_INSERT, cart), HttpStatus.OK);
    }

    @ApiOperation(value = "장바구니 수량 변경", notes = "장바구니 상품의 수량을 변경한다")
    @PutMapping
    public ResponseEntity<?> updateCount(CartDTO cart) throws Exception {
        cartRepo.save(Cart.builder()
                .no(cart.getCartNo())
                .opNo(cart.getOpNo())
                .count(cart.getCount())
                .build());
        return new ResponseEntity(DefaultResponse.res(StatusCode.OK, ResponseMessage.CART_UPDATE), HttpStatus.OK);
    }

    @ApiOperation(value = "장바구니 상품 삭제", notes = "장바구니 상품을 삭제한다")
    @DeleteMapping(value = "/{no}")
    public ResponseEntity<?> deleteCart(@PathVariable int no) throws Exception {
        cartRepo.deleteById(no);
        return new ResponseEntity(DefaultResponse.res(StatusCode.OK, ResponseMessage.CART_DELETE), HttpStatus.OK);
    }

}
