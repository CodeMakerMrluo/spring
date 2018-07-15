package com.springcomponent.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Administrator
 * @Title: Main
 * @ProjectName helloworld
 * @Description: TODO
 * @date 2018/7/15 00150:12
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Application.xml");
        Person p = (Person)context.getBean("abc");
        p.eat();

        Action action = (Action)context.getBean("action");
    }
}
