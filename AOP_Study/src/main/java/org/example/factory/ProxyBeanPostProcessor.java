package org.example.factory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class ProxyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        java.lang.reflect.InvocationHandler handler=new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("-----额外功能---------");
                Object ret = method.invoke(bean, args);
                return ret;
            }
        } ;

        //返回的就是生成的代理对象
       return Proxy.newProxyInstance(ProxyBeanPostProcessor.class.getClassLoader(),bean.getClass().getInterfaces(), handler);

    }
}
