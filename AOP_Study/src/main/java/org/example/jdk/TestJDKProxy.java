package org.example.jdk;

import org.example.proxy.User;
import org.example.proxy.UserService;
import org.example.proxy.UserServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestJDKProxy {
    public static void main(String[] args) {
        //1.创建原始对象
        UserService userService=new UserServiceImpl();
        InvocationHandler handler=new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("-------额外功能proxy log------");
                //原始方法运行
               Object ret= method.invoke(userService,args);
                return  ret;
            }
        };
        //2.jdk创建动态代理对象
        //classLoader :借用类加载器
       UserService userServiceProxy= (UserService) Proxy.newProxyInstance(TestJDKProxy.class.getClassLoader(),userService.getClass().getInterfaces(),handler);
       userServiceProxy.login("zhang","123");
       userServiceProxy.register(new User());
    }
}
