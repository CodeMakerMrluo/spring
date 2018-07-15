package com.cache.aop;

import com.cache.proxy.ComputerProxy;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 * @Title: ComputerImpl
 * @ProjectName eclipse
 * @Description: TODO
 * @date 2018/7/4 000422:39
 */
@Component
public class ComputerImpl implements Computer{


    public int add(int a, int b) {
        //System.out.println("正在调用添加方法,参数a :" + a + "b: " + b );

        int result = a + b;
        //System.out.println("调用添加方法结束" );

        return result;
    }

    public int sub(int a, int b) {
        //System.out.println("正在调用减方法,参数a :" + a + "b: " + b );
        int result = a - b;
        //System.out.println("调用减方法结束" );
        return result;
    }

    public int mul(int a, int b) {
        //System.out.println("正在调用乘法方法,参数a :" + a + "b: " + b );
        int result = a * b;
       // System.out.println("调用乘法方法结束" );
        return result;
}

    public int div(int a, int b) {
        //System.out.println("正在调用除法方法,参数a :" + a + "b: " + b );
        int result = a / b;
        //System.out.println("调用除法方法结束" );
        return result;
    }


    public static void main(String[] args) {
        /*Computer impl = new ComputerImpl();
        ComputerProxy proxy = new ComputerProxy(impl);
        impl = proxy.getComputer();
        System.out.println(impl.add(10,6));
        impl.sub(10,6);
        impl.mul(10,6);
        impl.div(10,6);*/
        ApplicationContext context = new ClassPathXmlApplicationContext("Application.xml");
        Computer computer = (Computer) context.getBean("computerImpl");
       // System.out.println(computer.add(1,3));
        System.out.println(computer.div(4,2));


    }
}
