package com.example.kurly.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "product")
@DynamicInsert
@DynamicUpdate
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

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getImg2() {
        return img2;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getPacking() {
        return packing;
    }

    public void setPacking(String packing) {
        this.packing = packing;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String getAllergy() {
        return allergy;
    }

    public void setAllergy(String allergy) {
        this.allergy = allergy;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory2() {
        return category2;
    }

    public void setCategory2(String category2) {
        this.category2 = category2;
    }

    public Integer getOption() {
        return option;
    }

    public void setOption(Integer option) {
        this.option = option;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getRecomm() {
        return recomm;
    }

    public void setRecomm(Integer recomm) {
        this.recomm = recomm;
    }
}
