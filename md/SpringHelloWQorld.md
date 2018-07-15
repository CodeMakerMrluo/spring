## Spring HelloWorld
Spring是一个开源的IOC、AOP框架，管理对象生命周期的框架

Spirng 优点:

- 轻量级：Spring是非侵入性的-----基于Spring开发的应用中的对象可以不依赖Spring的API
- 依赖注入(DI): IOC
- 面向切面编程（AOP）
- 容器：spring是容器，包含且管理应用对象(JavaBean)的生命周期
- 一站式框架：通过IOC AOP 整合各种企业级的开源框架，自身也有持久层展示层(Sping jdbc、Spring MVC)

Spring模块

AOP、ORM、WEB、DAO、Context、WEB MVC、Core

Spring开发流程

1. 倒入Spring jar包 必须要的: common-logging、Spring-beans、Spring-context、Spring-core、Spring-expression，考入放到项目

2. 创建spring容器的配置文件application.xml，所有javabean都需要在Spring容器中体现出来

3. 加入bean配置

   ```xml
   <bean id="person" class="com.spring.lzx.beans.Person">
           <property name="name" value="张三" ></property>
           <property name="age" value="10"></property>
    </bean>
   ```

4. 获取容器实例:

   ```java
   //获取容器对象
   ApplicationContext ac = new ClassPathXmlApplicationContext("application.xml");
   //如何通过容器对象来获取已经配置javabean
   Person person = (Person) ac.getBean("person");
   ```

以idea为例创建Spring helloworld

代码参考helloword、

