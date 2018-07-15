package com.spring.lzx.beans;

/**
 * @author Administrator
 * @Title: Dpg
 * @ProjectName helloworld
 * @Description: TODO
 * @date 2018/7/7 000723:08
 */
public class Dpg {
    // JavaBean IDO容器创建对象的时候，需要无参构造器
    public Dpg() {
        System.out.println("创建dog");
    }

    public Dpg(String type) {
        this.type = type;
    }

    private String type;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Dpg{" +
                "type='" + type + '\'' +
                '}';
    }
}
