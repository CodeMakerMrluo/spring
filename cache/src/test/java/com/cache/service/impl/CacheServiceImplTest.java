package com.cache.service.impl;

import com.cache.service.CacheServiceI;
import com.cache.service.UserServiceI;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Administrator
 * @Title: CacheServiceImplTest
 * @ProjectName eclipse
 * @Description: TODO
 * @date 2018/7/1 000114:07
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:Application.xml","classpath*:pring-mybatis.xml"})
@Transactional
public class CacheServiceImplTest {

    @Autowired
    private CacheServiceImpl cacheService;

    @Before
    public void before() {
      /*  //使用"spring.xml"和"spring-mybatis.xml"这两个配置文件创建Spring上下文
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"Application.xml","spring-mybatis.xml"});
        cacheService = (CacheServiceI)context.getBean("cacheService");*/
    }

    @Test
    public void getUser() {
        //cacheService.getUser();
    }

}
