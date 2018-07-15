package com.springcomponent.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author Administrator
 * @Title: MyService
 * @ProjectName helloworld
 * @Description: TODO
 * @date 2018/7/15 00150:28
 */
//Autowired 按照类型 自动装配 ，如果有多个service 会出出现 异常
@Service
public class MyService {
    @Autowired
    private Dao dao;
    public void add() {
        System.out.println("Service add");
        dao.insert();
    }
}
