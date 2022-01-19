package org.example.dynamic;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * invoke方法可以运行在原始方法之前 ，之后，之前和之后
 * MethodInvocation：额外功能所增加给的那个原始方法。
 * 返回值Object 原始方法的返回值
 */
public class Arround implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("额外功能运行在原始方法执行之前");
        Object ret=  methodInvocation.proceed();//原始方法运行
         System.out.println("额外方法运行在原始方法执行之后");
       return ret;

        //捕获异常
//        Object ret=null;
//        try {
//            ret=methodInvocation.proceed();
//        }catch (Throwable throwable){
//            System.out.println("--原方法抛出异常，额外功能执行---");
//            throwable.printStackTrace();
//        }
//        return  ret;


    }
}
