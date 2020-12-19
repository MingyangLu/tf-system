package com.alex.tfsystem.price.dao;


import com.alex.tfsystem.price.bean.Price;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PriceDAO {

    Price getPrice(Price price);
}
