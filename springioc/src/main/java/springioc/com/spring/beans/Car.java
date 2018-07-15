package springioc.com.spring.beans;

/**
 * @author Administrator
 * @Title: Car
 * @ProjectName helloworld
 * @Description: TODO
 * @date 2018/7/8 00089:50
 */
public class Car {
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Car{" +
                "type='" + type + '\'' +
                '}';
    }
}
