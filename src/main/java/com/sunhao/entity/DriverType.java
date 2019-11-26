package com.sunhao.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * 项目名称：driverCar
 * 类 名 称：Driver
 * 类 描 述：TODO
 * 创建时间：2019/11/25 8:50 下午
 * 创 建 人：sunhao
 */
public class DriverType {


    private String code; //和驾驶员表的驾驶类型相对应
    private String name;//准驾名称
    private String include;//准驾其它车型

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getInclude() {
        return include;
    }
    public void setInclude(String include) {
        this.include = include;
    }

    @Override
    public String toString() {
        return "DriverType [code=" + code + ", name=" + name + ", include=" + include + "]";
    }




}
