package com.spring.lzx.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author Administrator
 * @Title: MyBeanPostProcessor
 * @ProjectName helloworld
 * @Description: 专门处理IOC容器所以bean的初始化方法
 * @date 2018/7/8 000823:43
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("初始化方法之前的处理,方法： " + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("初始化方法之后的处理,方法： " + beanName);
        return bean;
    }
}
