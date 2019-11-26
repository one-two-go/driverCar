package com.sunhao.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 项目名称：driverCar
 * 类 名 称：Driver
 * 类 描 述：TODO
 * 创建时间：2019/11/25 8:50 下午
 * 创 建 人：sunhao
 */
public class Driver {

    private Integer id;//	主键

    @Size(max=30,min=1,message="长度不合格")
    private  String name;//	司机姓名

    @NotBlank
    @Pattern(regexp="[0-9]{6,12}")
    private  String phone;//	手机

    @NotBlank
    private  String password;//	密码
    @Pattern(regexp="[0-9]{15,18}")
    private  String driverLicense;//	驾驶证号

    private  String driverType;//	驾驶证等级
    private  Date issued;//	发证日期
    private  Date  created	;//注册时间

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", driverLicense='" + driverLicense + '\'' +
                ", driverType='" + driverType + '\'' +
                ", issued=" + issued +
                ", created=" + created +
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriverLicense() {
        return driverLicense;
    }

    public void setDriverLicense(String driverLicense) {
        this.driverLicense = driverLicense;
    }

    public String getDriverType() {
        return driverType;
    }

    public void setDriverType(String driverType) {
        this.driverType = driverType;
    }

    public Date getIssued() {
        return issued;
    }

    public void setIssued(Date issued) {
        this.issued = issued;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
