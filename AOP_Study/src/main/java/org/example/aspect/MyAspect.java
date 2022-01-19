package org.example.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 额外功能
 * public class Arround implements MethodInterceptor {
 *     @Override
 *     public Object invoke(MethodInvocation methodInvocation) throws Throwable {
 *         System.out.println("额外功能运行在原始方法执行之前");
 *         Object ret=  methodInvocation.proceed();//原始方法运行
 *          System.out.println("额外方法运行在原始方法执行之后");
 *        return ret;
 *        }
 * 切入点
 * <bean id="arround" class="org.example.dynamic.Arround"></bean>
 *     <aop:config>
 *         <aop:pointcut id="pc" expression="execution(* login(String,String))"/>
 *         <aop:advisor advice-ref="arround" pointcut-ref="pc"/>
 *     </aop:config>
 */
@Aspect
public class MyAspect {
    //定义切入点
    @Pointcut("execution(* *..UserServiceImpl.*(..))")
    public void myPointcut(){

    }
    @Around(value = "myPointcut()")
    public Object arround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("----aspect log----");
        Object ret=joinPoint.proceed();
        return  ret;
    }
    @Around(value = "myPointcut()")
    public Object arround2(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("----aspect tx----");
        Object ret=joinPoint.proceed();
        return  ret;
    }
}
