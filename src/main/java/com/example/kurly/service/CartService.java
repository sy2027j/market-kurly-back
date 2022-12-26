package com.example.kurly.service;

import com.example.kurly.model.dto.CartUserDTO;
import com.example.kurly.model.dto.UserDTO;
import com.example.kurly.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository repo;

    public List<CartUserDTO> selectCart(UserDTO userDto) {
        List<CartUserDTO> list = repo.findUserCartList(userDto);
        return list;
    }

}
