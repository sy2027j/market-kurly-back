package com.example.kurly.model.entity;

import com.example.kurly.model.dto.ProductDTO;
import com.example.kurly.model.dto.SimpleProductDTO;
import lombok.Getter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "product")
@DynamicInsert
@DynamicUpdate
@Getter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pd_no")
    private Integer no;

    @Column(name = "pd_name")
    private String name;

    @Column(name = "pd_img")
    private String img;

    @Column(name = "pd_img2")
    private String img2;

    @Column(name = "pd_price")
    private Integer price;

    @Column(name = "pd_dis")
    private Integer discount;

    @Column(name = "pd_des")
    private String des;

    @Column(name = "pd_del")
    private String delivery;

    @Column(name = "pd_seller")
    private String seller;

    @Column(name = "pd_packing")
    private String packing;

    @Column(name = "pd_unit")
    private String unit;

    @Column(name = "pd_weight")
    private String weight;

    @Column(name = "pd_origin")
    private String origin;

    @Column(name = "pd_deadline")
    private String deadline;

    @Column(name = "pd_notice")
    private String notice;

    @Column(name = "pd_allergy")
    private String allergy;

    @Column(name = "pd_category")
    private String category;

    @Column(name = "pd_category2")
    private String category2;

    @Column(name = "pd_option")
    private Integer option;

    @Column(name = "pd_tag")
    private String tag;

    @Column(name = "pd_brand")
    private String brand;

    @Column(name = "pd_count")
    private Integer count;

    @Column(name = "pd_recomm")
    private Integer recomm;

    public SimpleProductDTO MainList(){
        return SimpleProductDTO.builder().no(no).name(name).price(price).count(count).discount(discount).img(img).build();
    }

    public ProductDTO detailInfo(){
        return ProductDTO.builder()
                .no(no)
                .name(name)
                .price(price)
                .count(count)
                .discount(discount)
                .img(img)
                .allergy(allergy)
                .brand(brand)
                .category(category)
                .category2(category2)
                .deadline(deadline)
                .delivery(delivery)
                .des(des)
                .notice(notice)
                .option(option)
                .origin(origin)
                .packing(packing)
                .recomm(recomm)
                .seller(seller)
                .tag(tag)
                .unit(unit)
                .weight(weight)
                .build();
    }
}
