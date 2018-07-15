package com.springcomponent.bean;

import org.springframework.stereotype.Component;

/**
 * @author Administrator
 * @Title: Person
 * @ProjectName helloworld
 * @Description: TODO
 * @date 2018/7/15 00150:06
 */
// 1. Component 标注无需指定创建bean的ID的值，默认的配置命名
// 2.指定扫描包路径
@Component(value = "abc")
public class Person {

    public void eat() {
        System.out.println("正在吃东西");
    }
}
