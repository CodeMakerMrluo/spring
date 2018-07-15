package com.spring.lzx.beans;

import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 * @Title: Person
 * @ProjectName spring
 * @Description: TODO
 * @date 2018/7/7 00079:59
 */
public class Person {

    private String name;
    private int age;
    private Car car;
    private List<Car> cars;
    private List<String> names;
    private Map<String, Car> maps;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", car=" + car +
                ", cars=" + cars +
                ", names=" + names +
                ", maps=" + maps +
                '}';
    }

    public Person(String name, int age, Car car, List<Car> cars, List<String> names, Map<String, Car> maps) {
        this.name = name;
        this.age = age;
        this.car = car;
        this.cars = cars;
        this.names = names;
        this.maps = maps;
    }

    public void a() {
        System.out.println("初始化方法");
    }

    public void b() {
        System.out.println("销毁方法");
    }

    public Map<String, Car> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Car> maps) {
        this.maps = maps;
    }

    public Person(String name, int age, Car car, List<Car> cars, List<String> names) {
        this.name = name;
        this.age = age;
        this.car = car;
        this.cars = cars;
        this.names = names;
    }

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
        System.out.println("走入构造器当中");
    }

    public Person(String name, int age, List<Car> cars) {
        this.name = name;
        this.age = age;
        this.cars = cars;
    }

    public Person(String name, int age, Car car) {
        this.name = name;
        this.age = age;
        this.car = car;
        this.cars = cars;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        System.out.println("setCar方法");
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        System.out.println("setCars方法");
        this.cars = cars;
    }

    public void setName(String name) {
        System.out.println("setName方法");
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        System.out.println("setAge方法");
        this.age = age;
    }

}
