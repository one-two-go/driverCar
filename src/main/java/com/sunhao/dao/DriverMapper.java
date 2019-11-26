package com.sunhao.dao;

import com.sunhao.entity.Car;
import com.sunhao.entity.Driver;
import com.sunhao.entity.DriverType;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 项目名称：driverCar
 * 类 名 称：DriverMapper
 * 类 描 述：TODO
 * 创建时间：2019/11/25 8:55 下午
 * 创 建 人：sunhao
 */
public interface DriverMapper {

    @Select("SELECT * FROM t_driver_type")
    List<DriverType> getList();

    @Insert("insert into t_driver(name,phone,password,driver_license ,driver_type ,issued,created)"
            + " values(#{name},#{phone},#{password},#{driverLicense},#{driverType},#{issued},now())")
    int addDriver(Driver driver);

    @Select("select name,phone,password,driver_license as driverLicense ,driver_type as driverType ,issued,created "
            + " from t_driver where name=#{name} and password=#{password} limit 1")
    Driver login(Driver driver);

    @Select("SELECT * FROM t_driver_type WHERE code = (#{value}) LIMIT 1")
    DriverType getDriverTypeByCode(String driverType);

    @Select("select id,name,trademark,rent,car_type carType,pic_url picUrl ,created "
            + " from t_car where car_type in ('${value}')")
    List<Car> carlist(String drivable);

    @Select("select id,name,trademark,rent,car_type carType,pic_url picUrl ,created "
            + " from t_car where car_type in ('${value}')")
    List<Car> listCar(String drivable);


    @Insert("insert into t_car( name,trademark,rent,car_type ,pic_url ,created)"
            + " values(#{name},#{trademark},#{rent},#{carType},#{picUrl},now() )")
    void addCar(Car car);
}
