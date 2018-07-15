package com.cache.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Administrator
 * @Title: MyhandlerGJ
 * @ProjectName eclipse
 * @Description: TODO
 * @date 2018/7/4 000422:01
 */
public class MyhandlerGJ implements InvocationHandler {
    private Object target;

    Object bind(Object i) {
        target = i;
        Object itf;
        itf = Proxy.newProxyInstance(target.getClass().getClassLoader(), i.getClass().getInterfaces(), this);
        return itf;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我是动态代理!");
        Object result =   method.invoke(target,args);
        System.out.println("动态代理之后执行!");
        return result;
    }

    public static void main(String[] args) {
        TestServiceImpl impl = new TestServiceImpl();
        InvocationHandler pxy = new MyhandlerGJ();
        TestService itf = (TestService) ((MyhandlerGJ) pxy).bind(impl);
        itf.test1();
        itf.test2();
    }

}
