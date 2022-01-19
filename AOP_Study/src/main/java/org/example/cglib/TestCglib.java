package org.example.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import javax.jws.soap.SOAPBinding;
import java.lang.reflect.Method;

public class TestCglib {
    public static void main(String[] args) {
        // 1.创建原始对象
        UserService userService=new UserService();
        //2.通过cglib方式创建动态代理对象
        // Enhancer.create()      Enhancer.setClassLoader()   Enhancer.setSuperClass()    .setCallback()-->MethodInterceptor(cglib)
        Enhancer enhancer=new Enhancer();
        enhancer.setClassLoader(TestCglib.class.getClassLoader());
        enhancer.setSuperclass(userService.getClass());
        MethodInterceptor methodInterceptor=new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("--cglib log---");
                Object ret=method.invoke(userService,args);
                return  ret;
            }
        };
    }
}
