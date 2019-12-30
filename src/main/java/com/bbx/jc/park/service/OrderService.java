package com.bbx.jc.park.service;

import com.bbx.jc.park.entity.Order;
import com.bbx.jc.park.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    //获取全部
    public List<Order> getAll() {
        return orderMapper.findAllOrder();
    }

    public Order getById(int id) {
        return orderMapper.findById(id);
    }

    //模糊查询
    public List<Order> getByUserId(int id) {
        return orderMapper.findByUserId(id);
    }

    //模糊查询
    public List<Order> getByKey(String tmpKey) {
        String key = "%" + tmpKey + "%";
        return orderMapper.findByKey(key);
    }


    //删除
    public boolean delOrder(int id) {
        try {
            orderMapper.deleteOrder(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //添加
    public boolean addOrder(Order order) {
        try {
            orderMapper.insertOrder(order);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean updateOrderStatus(Order order) {
        try {
            orderMapper.updateStatus(order);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
