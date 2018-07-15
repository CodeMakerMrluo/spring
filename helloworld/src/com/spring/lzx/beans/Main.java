package com.spring.lzx.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.DateFormat;
import java.util.Date;

/**
 * @author Administrator
 * @Title: Main
 * @ProjectName spring
 * @Description: sping :IOC容器，可以帮助我们动态创建对象
 * @date 2018/7/7 000710:00
 */
public class Main {
    public static void main(String[] args) {
        //获取容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("application.xml");
        //如何通过容器对象来获取已经配置javabean
        /*Person person = (Person) ac.getBean("person");
        System.out.println(person);

        Dpg dpg = (Dpg)ac.getBean("com.spring.lzx.beans.Dpg");
        System.out.println(dpg);*/

        /**
         * 获取bean的三种常用方法
         * 1.getBean(String) String: id的值
         * 2.getBean(Class)
         * 3.getBaen(String, Class)
         */
        /*Dpg dog = (Dpg)ac.getBean("dog");
        System.out.println(dog);
        Dpg dog1 = ac.getBean(Dpg.class);
        System.out.println(dog);
        Dpg dog3 = ac.getBean("dog", Dpg.class);
        System.out.println(dog);*/
        Dpg dog = (Dpg)ac.getBean("dog");
        System.out.println(dog);
        Dpg dog1 = (Dpg)ac.getBean("dog1");
        System.out.println(dog1);
        Dpg dog2 = (Dpg)ac.getBean("dog2");
        System.out.println(dog2);

        Car car = (Car)ac.getBean("car");
        System.out.println(car);

        Car car2 = (Car)ac.getBean("car2");
        System.out.println(car2);

        Car car3 = (Car)ac.getBean("car3");
        System.out.println(car3);

        Person person1 = (Person) ac.getBean("person1");
        System.out.println(person1);
        Person person4 = (Person) ac.getBean("person4");
        System.out.println(person4);

        //集合属性
        Person person5 = (Person) ac.getBean("person5");
        System.out.println(person5);

        //集合属性
        Person person6 = (Person) ac.getBean("person6");
        System.out.println(person6);

        //集Spring El
        Person person7 = (Person) ac.getBean("person7");
        System.out.println(person7);

        Person person8 = (Person) ac.getBean("person8");
        System.out.println(person8);

        //IOC管理bean的生命周期
        Person person9= (Person) ac.getBean("person9");
        System.out.println(person9);

        //静态工厂方法
        DateFormat df = (DateFormat) ac.getBean("dataFormat");
        System.out.println(df);

        //实例工厂方法
        Date sdf = (Date) ac.getBean("date");
        System.out.println(sdf);

        //factoryBean
        Car car7 = (Car)ac.getBean("car7");
        System.out.println(car7);
    }
}

