package com.alex.tfsystem.demo.service.impl;


import com.alex.tfsystem.demo.bean.Demo;
import com.alex.tfsystem.demo.dao.DemoDAO;
import com.alex.tfsystem.demo.service.IDemoService;
import com.alex.tfsystem.price.bean.Price;
import com.alex.tfsystem.price.dao.PriceDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;


@Transactional
@Service("demoService")
public class DemoServiceImpl implements IDemoService {

    @Resource
    private DemoDAO demoDao;

    @Override
    public boolean insertDemo(Demo demo) {
        try{
            demoDao.insertDemo(demo);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
        return true;
    }

    @Override
    public boolean updateDemo(Demo demo) {
        try{
            demoDao.updateDemo(demo);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
        return true;
    }

    @Override
    public boolean deleteDemo(Demo demo) {
        try{
            demoDao.deleteDemo(demo);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
        return true;
    }

    @Override
    public Demo getDemo(Demo demo) {
        try{
            return demoDao.getDemo(demo);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<Demo> getDemoList(Demo demo) {
        try{
            return demoDao.getDemoList(demo);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }
}
