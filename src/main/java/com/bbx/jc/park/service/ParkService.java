package com.bbx.jc.park.service;

import com.bbx.jc.park.entity.Park;
import com.bbx.jc.park.mapper.ParkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkService {

    @Autowired
    private ParkMapper parkMapper;

    //获取全部
    public List<Park> getAll() {
        return parkMapper.findAllPark();
    }

    public List<Park> getAllByKey(int status) {
        return parkMapper.findAllParkByKey(status);
    }

    public List<Park> getByKey(String key) {
        return parkMapper.findParkByKey("%" + key + "%");
    }

    //查询
    public Park getById(int id) {
        return parkMapper.findCarById(id);
    }

    //通过id修改
    public boolean updateCar(Park car) {
        try {
            parkMapper.updateCar(car);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean updateCarStatus(Park car) {
        try {
            parkMapper.updateCarStatus(car);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //删除
    public boolean delCar(int id) {
        try {
            parkMapper.deleteCar(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //添加
    public boolean addCar(Park car) {
        try {
            parkMapper.insertCar(car);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
