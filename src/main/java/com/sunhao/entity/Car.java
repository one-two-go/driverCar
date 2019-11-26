package com.sunhao.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 * 项目名称：driverCar
 * 类 名 称：Driver
 * 类 描 述：TODO
 * 创建时间：2019/11/25 8:50 下午
 * 创 建 人：sunhao
 */
public class Car {

    private Integer id;//	主键
    private String name;//	车辆名称
    private String trademark;//	品牌
    private BigDecimal rent;//	日租金
    private String carType	;// 最低准驾车型
    private String picUrl	;//图片


    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", trademark='" + trademark + '\'' +
                ", rent=" + rent +
                ", carType='" + carType + '\'' +
                ", picUrl='" + picUrl + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTrademark() {
        return trademark;
    }

    public void setTrademark(String trademark) {
        this.trademark = trademark;
    }

    public BigDecimal getRent() {
        return rent;
    }

    public void setRent(BigDecimal rent) {
        this.rent = rent;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
}
