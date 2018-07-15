package com.spring.lzx.beans;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author Administrator
 * @Title: CarFactory
 * @ProjectName helloworld
 * @Description: 工厂bean
 * @date 2018/7/9 00090:22
 */
public class CarFactory implements FactoryBean<Object> {
    @Override
    public Object getObject() throws Exception {
        Car car1 = new Car();
        car1.setType("BENZ");
        return car1;
    }

    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
