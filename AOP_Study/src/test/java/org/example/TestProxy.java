package org.example;

import org.example.proxy.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestProxy {
    //测试静态代理类
    @Test
    public void test20(){
        UserService userService=new UserServiceProxy();
        userService.login("zhangsan","123456");
        userService.register(new User());
        System.out.println("------------------------------");
        OrderService orderService=new OrderServiceProxy();
        orderService.showOrder();
    }
    //测试动态代理
    @Test
    public void test1(){
        ApplicationContext context=new ClassPathXmlApplicationContext("/applicationContext.xml");
        // ApplicationContext context=new ClassPathXmlApplicationContext("/context1.xml");
        UserService userService= (UserService) context.getBean("userService");
        userService.login("ss","123");
        userService.register(new User());
        System.out.println("---------------------");
        OrderService orderService=(OrderService) context.getBean("orderService");
        orderService.showOrder();
    }
}
