package com.cache.service.impl;

import com.cache.domain.UserInfo;
import com.cache.service.UserServiceI;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Administrator
 * @Title: UserInfoServiceImplTest
 * @ProjectName eclipse
 * @Description: TODO
 * @date 2018/7/1 00012:09
 */
public class UserInfoServiceImplTest {

    private UserServiceI serviceI;

    @org.junit.Before
    public void before() {
        //使用"spring.xml"和"spring-mybatis.xml"这两个配置文件创建Spring上下文
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"Application.xml","spring-mybatis.xml"});
        serviceI = (UserServiceI)context.getBean("userService");

    }


    @org.junit.Test
    public void getUser() {
        List<UserInfo> list = serviceI.getUser();
        System.out.printf(list.size()+"");
    }
}