package com.alex.tfsystem.order.service.impl;

import com.alex.tfsystem.order.bean.Order;
import com.alex.tfsystem.order.bean.OrderPo;
import com.alex.tfsystem.order.dao.OrderDAO;
import com.alex.tfsystem.order.service.IOrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Transactional
@Service("orderService")
public class OrderServiceImpl implements IOrderService {

    @Resource
    OrderDAO orderDAO;

    @Override
    public void createOrder(Order order) {
        try{
            this.orderDAO.createOrder(order);
        }catch (Exception e){
            throw e;
        }

    }

    @Override
    public List<OrderPo> getOrderList(Order order) {
        try{
            return this.orderDAO.getOrderList(order);
        }catch (Exception e){
            throw e;
        }
    }
}
