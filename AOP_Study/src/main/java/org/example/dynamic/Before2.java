package org.example.dynamic;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class Before2 implements MethodBeforeAdvice {
    //作用:需要把运行在原始方法之前的额外功能写在before方法之中
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("---- new  method before advice----");
    }
}
