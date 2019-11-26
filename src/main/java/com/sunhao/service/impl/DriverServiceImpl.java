package com.sunhao.service.impl;

import com.sunhao.dao.DriverMapper;
import com.sunhao.entity.Car;
import com.sunhao.entity.Driver;
import com.sunhao.entity.DriverType;
import com.sunhao.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 项目名称：driverCar
 * 类 名 称：DriverServiceImpl
 * 类 描 述：TODO
 * 创建时间：2019/11/25 8:54 下午
 * 创 建 人：sunhao
 */
@Service
public class DriverServiceImpl implements DriverService {
    @Autowired
    DriverMapper driverMapper;

    @Override
    public List<DriverType> getList() {
        return driverMapper.getList();
    }

    //用户注册
    @Override
    public int addDriver(Driver driver) {
        return driverMapper.addDriver(driver);
    }

    //用户登陆
    @Override
    public Driver login(Driver driver) {
        return driverMapper.login(driver);
    }

    @Override
    public DriverType getDriverTypeByCode(String driverType) {
        return driverMapper.getDriverTypeByCode(driverType);
    }

    @Override
    public List<Car> carlist(String drivable) {
        return driverMapper.carlist(drivable);
    }

    /**
     * A1,B2,C3
     */
    @Override
    public List<Car> list(String drivable) {
        // TODO Auto-generated method stub
        return driverMapper.listCar(drivable);
    }

    @Override
    public void addCar(Car car) {
        // TODO Auto-generated method stub

        driverMapper.addCar(car);

    }
}
