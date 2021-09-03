package com.alex.tfsystem.demo.dao;


import com.alex.tfsystem.demo.bean.Demo;
import com.alex.tfsystem.price.bean.Price;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DemoDAO {

    boolean insertDemo(Demo demo);

    boolean updateDemo(Demo demo);

    boolean deleteDemo(Demo demo);

    Demo getDemo(Demo demo);

    List<Demo> getDemoList(Demo demo);
}
