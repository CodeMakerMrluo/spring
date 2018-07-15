package com.cache.aop.xml;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 * @Title: Validata
 * @ProjectName eclipse
 * @Description: TODO
 * @date 2018/7/5 000522:49
 */
// @Order(0)
public class ValidataAspect implements Ordered {

    @Before("execution(public int com.cache.aop.ComputerImpl.*(..))")
    public void a() {
        System.out.println("验证前置通知");
    }

    public int getOrder() {
        return 0;
    }
}
