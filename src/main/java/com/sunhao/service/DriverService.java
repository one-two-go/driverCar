package com.sunhao.service;

import com.sunhao.entity.Car;
import com.sunhao.entity.Driver;
import com.sunhao.entity.DriverType;

import javax.validation.Valid;
import java.util.List;

/**
 * 项目名称：driverCar
 * 类 名 称：DriverService
 * 类 描 述：TODO
 * 创建时间：2019/11/25 8:54 下午
 * 创 建 人：sunhao
 */
public interface DriverService {
    List<DriverType> getList();

    int addDriver(Driver driver);

    Driver login(Driver driver);

    DriverType getDriverTypeByCode(String driverType);

    List<Car> carlist(String drivable);

    List<Car> list(String drivable);

    /**
     * 添加车辆
     * @param car
     */
    void addCar(@Valid Car car);
}
