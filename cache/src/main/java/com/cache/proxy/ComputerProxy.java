package com.cache.proxy;

import com.cache.aop.Computer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Administrator
 * @Title: ComputerProxy
 * @ProjectName eclipse
 * @Description: TODO
 * @date 2018/7/4 000422:48
 */
public class ComputerProxy {

    //即将被代理的对象
    private Computer computer;

    public  ComputerProxy(Computer computer) {
        this.computer = computer;
    }

    //已经被代理对象
    public Computer getComputer () {
        ClassLoader loader = Computer.class.getClassLoader();
        Class[] interfaces = {Computer.class};
        InvocationHandler h = new InvocationHandler() {
            //proxy 代理对象
            //method 被代理对象当中的方法
            //args 方法参数
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // 调用被代理对象当中的某一个方法
                System.out.println("正在调用方法" + method.getName());
                Object o = method.invoke(computer,args);
                System.out.println("调用方法" + method.getName() + "结束");
                return o;
            }
        };
        Computer computer = (Computer) Proxy.newProxyInstance(loader, interfaces, h);
        return  computer;
    }

}
