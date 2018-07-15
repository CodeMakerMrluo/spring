package com.cache.aop.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author Administrator
 * @Title: ComputerAspect
 * @ProjectName eclipse
 * @Description: TODO
 * @date 2018/7/5 000520:24
 */

public class ComputerAspect {

    @Pointcut("execution(public int com.cache.aop.ComputerImpl.*(..))")
    private  void  getExcecution() {

    }
    //* ：通配符，所有
    // ..： 在方法的参数列表中使用，不限定类型,顺序，个数

    @Before("getExcecution()")
    //通知方法中的参数中加入JoinPoint
    public void a(JoinPoint jp) {
        //
        //如何让通知访问连接点的细节
        //JoinPoint： 接口类型，连接点类型
        Object[] arge = jp.getArgs();
        String methodName = jp.getSignature().getName();//获取方法的名称
        System.out.println("调用" + methodName + "之前,参数是：" + Arrays.asList(arge));
    }
    @After("getExcecution()")
    public  void b(JoinPoint jp) {
        Object[] arge = jp.getArgs();
        String methodName = jp.getSignature().getName();//获取方法的名称
        System.out.println("调用" + methodName + "之后,参数是：" + Arrays.asList(arge));
    }

    /**
     * 如何获取返回通知中方法返回的值
     * 1. 需要特定标注, @AfterReturning（returning='变量的名称'），作用 告知spring要获取目标对象(被代理的对象)法方的返回的result
       2. 通知的参数列表中，指定一个形名字和returning属性的名字一致
     * @param jp
     * @param result
     */
    //返回通知  如何获取返回通知中方法返回的值  将returning 属性加入到@AfterReturning 可获取到连接点的返回值
    @AfterReturning(pointcut = "getExcecution()", returning = "result")
    public void c(JoinPoint jp, Object result) {
        Object[] arge = jp.getArgs();
        String methodName = jp.getSignature().getName();//获取方法的名称

        System.out.println("调用" + methodName + "正常返回结果之后,参数是：" + Arrays.asList(arge)
        + "正常返回结果" + result
        );
    }

    @AfterThrowing(pointcut = "execution(public int com.cache.aop.ComputerImpl.*(..))", throwing = "ex")
    public void d(JoinPoint jp, NullPointerException ex) {
        Object[] arge = jp.getArgs();
        String methodName = jp.getSignature().getName();//获取方法的名称

        System.out.println("调用" + methodName + "正常返回结果之后,参数是：" + Arrays.asList(arge)
                + "出现异常" + ex.getMessage()
        );
    }

    //是否执行這个连接点
    //环绕通知需要在通知方法列表中，提供ProceedingJoinPoint接口的形参
    //环绕通知
    @Around("execution(public int com.cache.aop.ComputerImpl.*(..))")
    public void  e(ProceedingJoinPoint pjp) {
        pjp.getSignature().getName();
        pjp.getArgs();
        try {
            //前置通知
            System.out.println("前置通知");
            Object result =  pjp.proceed();
            //返回通知
            System.out.println("正常返回结果通知,结果" + result);
        } catch (Throwable throwable) {
            System.out.println("异常通知");
            //异常通知
            throwable.printStackTrace();
        }

        //后置通知
        System.out.println("后置通知");
    }


}
