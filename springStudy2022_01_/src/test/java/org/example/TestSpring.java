package org.example;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    @Test
    public void test3(){
        //获得spring工厂   非web环境下的工厂
        ApplicationContext context=new ClassPathXmlApplicationContext("/applicationContext.xml") ;
        //获得对象
        Person person=(Person) context.getBean("person");
        System.out.println(person);
    }
    @Test
    public void test4(){
        ApplicationContext context=new ClassPathXmlApplicationContext("/applicationContext.xml") ;
        //获得对象
        //使用class方式需要注意在配置文件中只能有一个bean的class属性为Person  如果有多个spring会不知道找谁
        Person person=(Person) context.getBean(Person.class);
    }
}

