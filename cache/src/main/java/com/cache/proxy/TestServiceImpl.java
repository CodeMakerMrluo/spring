package com.cache.proxy;

/**
 * @author Administrator
 * @Title: TestServiceImpl
 * @ProjectName eclipse
 * @Description: TODO
 * @date 2018/7/4 000420:54
 */
public class TestServiceImpl implements TestService {
    public void test1() {
        System.out.println("========test1===========");
        System.out.println(this.getClass().getName());
        this.test2();
    }

    public void test2() {
        System.out.println(this.getClass().getName());
        System.out.println("========test2============");
    }
}
