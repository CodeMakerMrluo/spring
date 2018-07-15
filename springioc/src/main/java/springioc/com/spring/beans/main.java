package springioc.com.spring.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Administrator
 * @Title: main
 * @ProjectName helloworld
 * @Description: TODO
 * @date 2018/7/8 000810:00
 */
public class main {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("application.xml");
        Person person = (Person) ac.getBean("person");
        System.out.println(person);
    }
}
