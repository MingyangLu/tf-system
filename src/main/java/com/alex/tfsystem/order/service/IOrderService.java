package com.alex.tfsystem.order.service;

import com.alex.tfsystem.order.bean.Order;

import java.util.List;

public interface IOrderService {
    void createOrder(Order order);

    List<Order> getOrderList(Order order);
}
