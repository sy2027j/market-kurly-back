package com.example.kurly.service;

import com.example.kurly.model.dto.PdOptionDTO;
import com.example.kurly.model.dto.ProductDTO;
import com.example.kurly.model.dto.SimpleProductDTO;
import com.example.kurly.model.entity.Product;
import com.example.kurly.model.entity.ProductOption;
import com.example.kurly.repository.PdOptionRepository;
import com.example.kurly.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repo;
    private final PdOptionRepository opRepo;

    //상품 단건 조회
    public ProductDTO getProduct(int no) {
        return repo.findById(no).orElseThrow(()-> new NullPointerException()).detailInfo();
    }

    //상품 랜덤 4개 조회
    public List<SimpleProductDTO> findAllInnerFetchJoin() {
        List<SimpleProductDTO> dto = new ArrayList<>();
        List<Product> list = repo.findAllInnerFetchJoin();
        for(int i=0; i<list.size(); i++){
            dto.add(list.get(i).MainList());
        }
        return dto;
    }

    //베스트 상품 20개 조회
    public List<SimpleProductDTO> findBestProduct(){
        List<SimpleProductDTO> dto = new ArrayList<>();
        List<Product> list = repo.findTop20ByOrderByCountDesc();
        for(int i=0; i<list.size(); i++){
            dto.add(list.get(i).MainList());
        }
        return dto;
    }

    //할인율 높은 상품 20개 조회
    public List<SimpleProductDTO> findHighDiscountProduct(){
        List<SimpleProductDTO> dto = new ArrayList<>();
        List<Product> list = repo.findTop20ByOrderByDiscount();
        for(int i=0; i<list.size(); i++){
            dto.add(list.get(i).MainList());
        }
        return dto;
    }

    //옵션 조회
    public List<PdOptionDTO> findProductOption(int pdNo){
        List<PdOptionDTO> dto = new ArrayList<>();
        List<ProductOption> list = opRepo.findByPdNo(pdNo);
        for(int i=0; i<list.size(); i++){
            dto.add(list.get(i).optionInfo());
        }
        return dto;
    }
}
