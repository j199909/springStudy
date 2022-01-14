package org.example;

import org.example.proxy.*;
import org.junit.Test;

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
}
