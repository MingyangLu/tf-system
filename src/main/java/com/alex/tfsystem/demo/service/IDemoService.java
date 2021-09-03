package com.alex.tfsystem.demo.service;

import com.alex.tfsystem.demo.bean.Demo;

import java.util.List;

public interface IDemoService {

    boolean insertDemo(Demo demo);

    boolean updateDemo(Demo demo);

    boolean deleteDemo(Demo demo);
    Demo getDemo(Demo demo);

    List<Demo> getDemoList(Demo demo);
}
