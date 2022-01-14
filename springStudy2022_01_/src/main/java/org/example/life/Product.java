package org.example.life;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

//public class Product implements InitializingBean {
//    public Product(){
//        System.out.println("Product");
//    }
//
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        System.out.println("初始化");
//    }
//    public void myInit(){
//        System.out.println("myInit方法");
//    }
//}

/**
 * 如果两个初始化方法都存在 先执行spring提供的，再执行自己定义的myInit
 * 注入发生在初始化之前
 */
public  class Product  implements DisposableBean {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("注入");
    }

    public Product(){
        System.out.println("Product");
    }
    public void myInit(){
        System.out.println("myInit");
    }

    /**
     * 销毁 也可以自定义 在配置文件配置 destory-method
     * 销毁只能singleton使用 property不能用
     */
    @Override
    public void destroy() throws Exception {
        System.out.println("销毁");
    }
}
