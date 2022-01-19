package org.example.aspect;

import org.example.proxy.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext2.xml");
        UserService userService=(UserService) context.getBean("userService");
        userService.login("zhang","123");
        userService.register(new User());
    }
}
