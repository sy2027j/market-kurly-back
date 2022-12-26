package com.example.kurly.repository;

import com.example.kurly.model.dto.CartUserDTO;
import com.example.kurly.model.dto.UserDTO;

import java.util.List;

public interface CartRepositoryCustom {
    List<CartUserDTO> findUserCartList(UserDTO dto);
}
