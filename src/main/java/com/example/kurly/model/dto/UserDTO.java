package com.example.kurly.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
public class UserDTO {

    private String id;
    private String password;
    private String name;
    private String email;
    private Integer phone;
    private String addr;
    private String addrDetail;
    private Integer zipcode;
    private Integer gender;
    private Integer year;
    private Integer month;
    private Integer day;

}