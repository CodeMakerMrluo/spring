package com.cache.proxy;

import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.annotation.PostConstruct;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Administrator
 * @Title: Myhandler
 * @ProjectName eclipse
 * @Description: TODO
 * @date 2018/7/4 000420:52
 */
public class Myhandler implements InvocationHandler {

    public Object target;

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我是动态代理!");
        Object result =   method.invoke(target,args);
        System.out.println("动态代理之后执行!");
        return result;
    }


    public  Myhandler(Object target){
        this.target = target;
    }

    public static void main(String[] args) {
        //创建被代理者
        TestServiceImpl testService = new TestServiceImpl();
        //创建InvocationHandler，来描述我们希望代理者执行哪些操作
        InvocationHandler i = new Myhandler(testService);
        //通过刚才创建的InvocationHandler，创建真正的代理者。第一个参数是类加载器，第二个参数是这个代理者实现哪些接口
        TestService iTest = (TestService)Proxy.newProxyInstance(TestServiceImpl.class.getClassLoader(), new Class[] {TestService.class}, i);
        // 只有通过代理者代理得类才执行
        System.out.println("代理名称" + iTest.getClass().getName());
        iTest.test1();
       // iTest.test2();
    }

}
