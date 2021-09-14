package com.alex.tfsystem.order.service;

import com.alex.tfsystem.order.bean.Order;
import com.alex.tfsystem.order.bean.OrderPo;

import java.util.List;

public interface IOrderService {
    void createOrder(Order order);

    List<OrderPo> getOrderList(Order order);
}
