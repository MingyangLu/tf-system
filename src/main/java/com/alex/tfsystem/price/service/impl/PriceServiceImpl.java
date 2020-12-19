package com.alex.tfsystem.price.service.impl;


import com.alex.tfsystem.price.bean.Price;
import com.alex.tfsystem.price.dao.PriceDAO;
import com.alex.tfsystem.price.service.IPriceService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


@Transactional
@Service("priceService")
public class PriceServiceImpl implements IPriceService {

    @Resource
    private PriceDAO priceDAO;

    @Transactional(readOnly = true)
    @Override
    public Price getPrice(Price price) {
        try{
            Price priceResult = priceDAO.getPrice(price);
            return priceResult;
        }catch (Exception e){
            throw e;
        }
    }

}
