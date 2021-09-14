package com.alex.tfsystem.order.dao;

import com.alex.tfsystem.order.bean.Order;
import com.alex.tfsystem.order.bean.OrderPo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderDAO {

    void createOrder(Order order);

    void updateOrder(Order order);

    List<OrderPo> getOrderList(Order order);

}
