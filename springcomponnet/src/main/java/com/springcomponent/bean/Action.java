package com.springcomponent.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author Administrator
 * @Title: Action
 * @ProjectName helloworld
 * @Description: TODO
 * @date 2018/7/15 00150:26
 */
@Controller
public class Action {
    @Autowired(required = false)
    private MyService service;
    public String excute() {
        System.out.println("走入到Action excute方法");
        service.add();
        return "";
    }
}
