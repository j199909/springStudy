package org.example.factory;

import org.example.proxy.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext1.xml");
        UserService userService=(UserService) context.getBean("userService");
        userService.login("zhangsan1","123456");
        userService.register(new User());
    }
}
