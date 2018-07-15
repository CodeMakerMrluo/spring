#### IOC & DI

##### Inversion of Control: 其思想是反转资源的获取的方向

1. 传统资源：向容器发起请求查找资源Person p = new Person()
2. IOC：容器主动将资源推送给它所管理的组件，组件选择一种合适的方式接受资源 Person p = ac.getBean("a")

DI: IOC的另外一种表达方式，即组件以一些预先定义好的方式(例如:setter方法) 接受来自容器的资源注入

配置Bean：

在XML文件中通过Bean节点来配置bean

```xml
<bean id="person" class="com.spring.lzx.beans.Person">
    <property name="name" value="张三" ></property>
    <property name="age" value="10"></property>
</bean>
```

id:Bean的名称(唯一)，如果没有ID Spring自动将权限定性类名作为Bean的名字 Class： 路径



##### IOC容器实现:

1. beanfactory 底层 不常用
2. Application beanfactory 子接口常用，主要实现类
   1. ClassPathXmlApplicationContext：从类路径下加载配置文件
   2. fileSetemXmlApplicationContext: 从文件系统加载配置文件

ApplicationContext 在初始化上下文的时候就实例化所以单例的bean

WebApplicationContext 专门为Web应用准备的



```java
/**
         * 获取bean的三种常用方法
         * 1.getBean(String) String: id的值
         * 2.getBean(Class)
         * 3.getBaen(String, Class)
         */
Dpg dog = (Dpg)ac.getBean("dog");
System.out.println(dog);
Dpg dog1 = ac.getBean(Dpg.class);
System.out.println(dog);
Dpg dog3 = ac.getBean("dog", Dpg.class);
System.out.println(dog);
```



#### DI依赖注入三种实现

1. 属性注入

   set方法

   IOC的配置文件， 通过<property  name="属性名称" value="属性的值"></property>节点完成注入

   <property  name="属性名称" >

   ​	<value></value>

   </property>

   ```xml
   <bean id="dog" class="com.spring.lzx.beans.Dpg">
       <property name="type" value="哈士奇"></property>
   </bean>
   <bean id="dog1" class="com.spring.lzx.beans.Dpg">
       <property name="type" >
           <value>金毛</value>
       </property>
   </bean>
   ```

2. 构造器注入 

   ```xml
   <!--构造器注入-->
   <bean id="dog2" class="com.spring.lzx.beans.Dpg">
   <constructor-arg value="藏獒"></constructor-arg>
   </bean>
   ```

   1. 按照顺序进行注入<constructor-arg></constructor-arg>

   ```xml
   <!-- 无index按照顺序进行参数构造 -->
   <bean id="car" class="com.spring.lzx.beans.Car">
       <constructor-arg value="宝马"></constructor-arg>
       <constructor-arg value="一汽"></constructor-arg>
       <constructor-arg value="30000000"></constructor-arg>
   </bean>
   ```

   2. 按照类型

3. 工厂方法



##### 注入属性的细节:

​    如果注入的属性有特殊的字符,<![CDATA[]]> 通过value属性来进行注入。<value></value>

```xml
<bean id="car3" class="com.spring.lzx.beans.Car">
    <property name="type" >
        <!--字面值-->
        <value><![CDATA[<宝马>]]></value>
    </property>
    <property name="factory" value="吉利汽车"></property>
    <property name="price" value="20000"></property>
</bean>
```

##### bean中如何引用其他的bean

​    配置文件中通过ref属性或者 ref子节点进行资源的注入

``` xml
<bean id="person1" class="com.spring.lzx.beans.Person">
    <property name="name" value="李四" ></property>
    <property name="age" value="20"></property>
    <property name="car" ref="car"></property>
</bean>
```

内部bean的引用: bean 只能使用一次 和java内部类相像 无需声明ID

```xml
<bean id="person1" class="com.spring.lzx.beans.Person">
    <property name="name" value="李四" ></property>
    <property name="age" value="20"></property>
    <property name="car" >
        <!-内部bean-->
        <bean class="com.spring.lzx.beans.Car">
            <property name="type" >
                <!--字面值-->
                <value>奔弛</value>
            </property>
            <property name="factory" value="长安"></property>
            <property name="price" value="50000"></property>
        </bean>
    </property>
</bean>
```

空值引用

```xml
 <bean id="person3" class="com.spring.lzx.beans.Person">
     <property name="name" value="李四" ></property>
     <property name="age" value="20"></property>
     <property name="car" >
         <null></null>
     </property>
</bean>		
```



级联属性 

```xml
 <!--级联属性 -->
<bean id="car4" class="com.spring.lzx.beans.Car">

</bean>
<bean id="person4" class="com.spring.lzx.beans.Person">
    <property name="name" value="李四" ></property>
    <property name="age" value="20"></property>
    <property name="car" ref="car4">
    </property>
    <property name="car.type" value="奔弛"></property>
</bean>
```



##### List属性注入

1. list 标签
2. ref指定外部bean
3. 数组使用list标签
4. Set 使用set标签

```xml
<!--集合属性注入-->
<bean id="person5" class="com.spring.lzx.beans.Person">
    <property name="name" value="jack"></property>
    <property name="age" value="12"></property>
    <property name="cars">
        <list>
            <bean  class="com.spring.lzx.beans.Car">
                <property name="type" value="BWM"></property>
                <property name="factory" value="华晨宝马"></property>
                <property name="price" value="3000"></property>
            </bean>
            <bean  class="com.spring.lzx.beans.Car">
                <property name="type" value="BenZ"></property>
                <property name="factory" value="梅德赛斯"></property>
                <property name="price" value="3000"></property>
            </bean>
        </list>
    </property>
</bean>
<!--集合属性注入 外部bean-->
<bean id="carA"  class="com.spring.lzx.beans.Car">
    <property name="type" value="BWM"></property>
    <property name="factory" value="华晨宝马"></property>
    <property name="price" value="3000"></property>
</bean>
<bean id="carB"  class="com.spring.lzx.beans.Car">
    <property name="type" value="BenZ"></property>
    <property name="factory" value="梅德赛斯"></property>
    <property name="price" value="3000"></property>
</bean>
<bean id="person5" class="com.spring.lzx.beans.Person">
    <property name="name" value="jack"></property>
    <property name="age" value="12"></property>
    <property name="cars">
        <list>
            <ref bean="carA"></ref>
            <ref bean="carB"></ref>
        </list>
    </property>
</bean>
```



Map映射集合，通过map标签定义 使用多个entry字标签

``` xml
 <!--集合属性注入-->
<bean id="carA"  class="com.spring.lzx.beans.Car">
    <property name="type" value="BWM"></property>
    <property name="factory" value="华晨宝马"></property>
    <property name="price" value="3000"></property>
</bean>
<bean id="carB"  class="com.spring.lzx.beans.Car">
    <property name="type" value="BenZ"></property>
    <property name="factory" value="梅德赛斯"></property>
    <property name="price" value="3000"></property>
</bean>
<bean id="person5" class="com.spring.lzx.beans.Person">
    <property name="name" value="jack"></property>
    <property name="age" value="12"></property>
    <property name="cars">
        <list>
            <ref bean="carA"></ref>
            <ref bean="carB"></ref>
        </list>
    </property>
    <property name="names">
        <list>
            <value>AAAAAAAAAAAA</value>
            <value>BBBBBBBBBBBB</value>
        </list>
    </property>
    <property name="maps">
        <map>
            <entry key="first" value-ref="carA"></entry>
            <entry key="second" value-ref="carB"></entry>
        </map>
    </property>
</bean>
```



外部list 需要引入xmlns:util="http://www.springframework.org/schema/util" 命名空间

```xml
<bean id="person5" class="com.spring.lzx.beans.Person">
    <property name="name" value="jack"></property>
    <property name="age" value="12"></property>
    <!-- 外部list 需要引入xmlns:util="http://www.springframework.org/schema/util" 命名空间-->
    <property name="cars" ref="carlist">
        <!--       <list>
                <ref bean="carA"></ref>
                <ref bean="carB"></ref>
            </list>-->
    </property>
    <property name="names">
        <list>
            <value>AAAAAAAAAAAA</value>
            <value>BBBBBBBBBBBB</value>
        </list>
    </property>
    <property name="maps">
        <map>
            <entry key="first" value-ref="carA"></entry>
            <entry key="second" value-ref="carB"></entry>
        </map>
    </property>
</bean>
```



##### P命名空间

spring 2.5后引入 p命名空间以属性方式注入  P:type="BWM"



##### bean 自动装配自动注入，可以让一个bean的对象自动引用其他的bean

1. byName  按照bean属性名称必须与引用的bean的id保持一 至
2. byType 按照类型  缺点： 如果IOC容器中存在多个相同类型的bean的时候 会出现异常



##### bean之前的关系: 

1. 继承、制定 parent即继承，覆盖可重新定义属性，未重新定义的从主类继承

2. 依赖 创建abstract 作为模版bean

   abstract类: 

   1. 抽象类不允许被实例化
   2. 苹果类、香蕉类 （将具体的对象抽象）==》水果类(具有相同的行为的类的进一步抽象)

   抽象类创建在bean标签中指定 abstract =“true”   calss可以去掉  

   3. 继承类有些属性不能被继承  autowrie abstract

3. 允许指定前置依赖类 值得depends-on 多个类可通过逗号制定

##### bean的作用域： 通过scope 指定

1. singleton  默认 ioc容器中仅有一个，容器内共享
2. prototype 每次使用都重新创建一个bean
3. request 发送一次请求 创建一次
4. session Http Session 共享bean 仅实用WebApplication



##### 引入外部属性文件，完成属性与bean的配置的分离

``` xml
<!-- 引入外部属性文件: 完成与bean的配置分离
1.创建属性:*.properties key=value
2.配置文件当中去应用外部文件当中的内容 通过key值来引用
3.告知IOC容器引用的属性文件
-->
<context:property-placeholder location="classpath:bean.properties"></context:property-placeholder>
<bean id="person6" class="com.spring.lzx.beans.Person">
    <property name="name" value="${personName}"></property>
</bean>
```

##### 

##### Spring EL 

1. SpEL 可以实现 

   I、 通过bean的id对bean进行引用 ref属性 ref节点

   II、调用方法已经引用对象的属性
         访问对象的属性、方法

   III、  计算表达式的值： 算术运算 关系运算、正则表达等

   ```xml
    <!-- spring EL  -->
   <bean id="person7" class="com.spring.lzx.beans.Person">
       <property name="name" value="tom"></property>
       <property name="age" value="12"></property>
       <property name="car" value="#{car5}"></property>
   </bean>
   
   <bean id="person8" class="com.spring.lzx.beans.Person">
       <property name="name" value="#{person7.name.toUpperCase()}"></property>
       <property name="age" value="#{person7.age + 10}"></property>
       <property name="car" value="#{person7.car}"></property>
   </bean>
   
   ```

   ​     

##### IOC管理bean的生命周期：

1. 通过构造器或是工厂方法创建对象
2. 需要将属性进行注入
3. 调入初始化方法
4. 正常使用bean
5. 调用销毁方法

##### 创建Bean的后置处理器

后置处理器允许在调用初始化方法的前后对bean进行额外的处理，是针对IOC所有bean的后置处理

1. 通过构造器或是工厂方法创建对象
2. 需要将属性进行注入
3. **后置处理器的前置处理**
4. 调入初始化方法
5. **后置处理器的后置处理**
6. 正常使用bean
7. 调用销毁方法

```java
package com.spring.lzx.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author Administrator
 * @Title: MyBeanPostProcessor
 * @ProjectName helloworld
 * @Description: 专门处理IOC容器所以bean的初始化方法
 * @date 2018/7/8 000823:43
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("初始化方法之前的处理,方法： " + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("初始化方法之后的处理,方法： " + beanName);
        return bean;
    }
}

	<!-- xml 专门处理IOC容器所以bean的初始化方法 -->
    <bean id="prosser" class="com.spring.lzx.beans.MyBeanPostProcessor">

    </bean>

```



##### 静态工厂方法 ：

将创建bean的对象过程封装到静态方法中，需要在Bean的class属性中指定拥有该工程的方法的类，同时在factory-method属性制定工厂方法的名称最后使用<constrector-arg>元素为该方法传递元素。

1. java.text.DateFormat的抽象类 静态方法 getDateFormatInstance(Int) 获取一个日期 格式中的实例

```xml
<!--静态工厂方法  -->
<bean id="dataFormat" class="java.text.DateFormat" factory-method="getDateInstance">
    <constructor-arg value="3"></constructor-arg>
</bean>
```

```java
//静态工厂方法
DateFormat df = (DateFormat) ac.getBean("dataFormat");
System.out.println(df);
```

##### 实例工厂方法：

将创建bean的对象过程封装到实例中

要声明通过实例工厂创建bean 在bean的factory-bean指定有该工厂方法的bean 在factory-method 指定工程方法名称 使用constructor-arg 传递canshu

1. java.text.SimpleDataFormat public Data parse(String)  匹配类型

```xml
<!--实例工厂方法  -->
<bean id="simpleDateFormar" class="java.text.SimpleDateFormat" >
    <constructor-arg value="yyy-MM-dd hh-mm-ss"></constructor-arg>
</bean>
<!-- "2001-12-12 12-12-12" -->
<bean id="date" factory-bean="simpleDateFormar" factory-method="parse">
    <constructor-arg value="2001-12-12 12-12-12"></constructor-arg>
</bean>
```

```java
 //实例工厂方法
Date sdf = (Date) ac.getBean("date");
System.out.println(sdf);
```

##### 实现FactoryBean 接口在Spring IOC中配置Bean

SPring中两种Bean  普通Bean、

factoryBean： 其返回的对象不是指定类的实例，返回是该factory Bean的getObject方法所返回的对象

```java
package com.spring.lzx.beans;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author Administrator
 * @Title: CarFactory
 * @ProjectName helloworld
 * @Description: 工厂bean
 * @date 2018/7/9 00090:22
 */
public class CarFactory implements FactoryBean<Object> {
    @Override
    public Object getObject() throws Exception {
        Car car1 = new Car();
        car1.setType("BENZ");
        return car1;
    }

    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
```

```xml
<!-- factory配置 -->
<bean id="car6" class="com.spring.lzx.beans.Car">
    <property name="type" value="BM"></property>
</bean>
<bean id="car7" class="com.spring.lzx.beans.CarFactory" >

</bean>
```

IOC 注解实现


// 1. Component 标注无需指定创建bean的ID的值，默认的配置命名
// 2. 指定扫描包路径
// 3. @Autowired按照类型进行自动装配

@Component  标准实体bean 通用
@Controller
@Repository
@Service

@Autowired  按照类型进行自动装配，如果出现多个同名service 报错  required 属性是否自动装配
@Resources 按照名字进行自动装配
@Inject  和@Autowired 没required 属性
