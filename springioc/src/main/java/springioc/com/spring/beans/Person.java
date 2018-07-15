package springioc.com.spring.beans;

/**
 * @author Administrator
 * @Title: Person
 * @ProjectName helloworld
 * @Description: TODO
 * @date 2018/7/8 00089:51
 */
public class Person {
    private String name;
    private Car car;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", car=" + car +
                '}';
    }
}
