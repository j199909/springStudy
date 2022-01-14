package org.example;


import com.sun.deploy.panel.IProperty;
import org.example.beanpost.Category;
import org.example.factorybean.ConnectionFactoryBean;
import org.example.life.Product;
import org.example.scope.Account;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.util.Arrays;

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
//        Person person=(Person) context.getBean(Person.class);

        //bean定义的名字 这个方法返回的是bean对象们的id  返回一个数组
//        String[] beanDefinitionNames=context.getBeanDefinitionNames();
//        System.out.println(Arrays.toString(beanDefinitionNames));

        //获取工厂中所有这个类型即Person类型的bean的id
        //context.getBeanNamesForType(Person.class);

        //判断有没有存在指定id的bean  返回值是boolean
        //context.containsBeanDefinition("person");  true

        //也是判断是否存在这个id的Bean
        //context.containsBean("person");

    }

    //测试配置文件
    //只配置一个bean标签
    @Test
    public void test5(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person=context.getBean(Person.class);
        System.out.println(person);
        //spring 会分配id
       String[] beanDefinitionNames= context.getBeanDefinitionNames();
        /**
         * 场景：只需要使用一次不需要配置id  使用多次要配置id
         */

    }
    //用于测试name属性
    //spring支持通过name属性获取bean对象
    //相同:id class配置和 name class 定义是等效的
    //区别: id只有一个 不能定义多个;name可以定义多个
    //xml id配置必须要遵守命名规范 字母开头  name命名是没有要求的  今天现在id可以反斜线等开头

    @Test
    public void test6(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person=(Person) context.getBean("p");
        System.out.println(person);

        //containsBeanDefinition只能判断id
       context.containsBeanDefinition("person");

        //containsBean  id和name都能判断
        context.containsBean("person");
        context.containsBean("p");
    }
    @Test
    public void test7(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person=(Person) context.getBean("person");
        /**
         * 这种通过编码方式的set赋值存在耦合
         * 假如以后要赋值一个李四，就需要来修改代码
         * 通过注入来解决 也就是配置文件来解决
         * 注入的步骤：提供get set 方法
         *          配置spring配置文件
         */
       person.setId(1);
      person.setName("张三");
        System.out.println(person);
    }
    /**
     * 通过配置文件来注入  不需要自己调用set方法 工作都集中在配置文件中 解耦合
     * 注入的原理：set get方法 对应配置文件 的property和value  假如把set get 方法删除掉 ，会报错
     */
    @Test
    public void test8(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person=(Person) context.getBean("person");
        System.out.println(person);
    }
    //测试
    @Test
    public void test9(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        Connection conn=(Connection) context.getBean("conn");
        Connection coon2=(Connection)context.getBean("conn");
        System.out.println(conn==coon2);
    }

    @Test
    public void test10(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取ConnectionFactoryBean的对象
//        ConnectionFactoryBean conn=(ConnectionFactoryBean) context.getBean("conn");
//        System.out.println(conn);

        //获取connect 对象
        Connection connection=(Connection) context.getBean("conn");
        System.out.println(connection);

    }
    //测试实例工厂
    @Test
    public void test11(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        Connection conn=(Connection) context.getBean("conn");
        System.out.println(conn);
    }
    //静态工厂  静态工厂的配置不需要创建对象 只需要指定工厂方法
    @Test
    public void test12(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        Connection conn=(Connection) context.getBean("conn");
        System.out.println(conn);
    }
    //测试简单对象创建次数
    @Test
    public void test13(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        Account account=(Account) context.getBean("account");
        Account account2=(Account) context.getBean("account");
        System.out.println(account==account2);   //singleton 创建一次 返回true   prototype 多次 false  默认singleton
    }
    //演示生命周期
    @Test
    public void test14(){
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
      //执行结果： product 证明无参构造方法被调用 singleton:工厂创建的同时创建对象
        //scope=property,getBean方法才会调用构造方法。
        System.out.println(context.getBean("product"));
        context.close();//销毁

    }
    //测试配置文件参数化
    @Test
    public void test15(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext1.xml");
        System.out.println(context.getBean("conn"));
    }
    //测试自定义类型转换器 日期类型
    @Test
    public void test16(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext2.xml");
        org.example.converter.Person person=(org.example.converter.Person) context.getBean("person");
        System.out.println(person);
    }

    //测试BeanPostProcess
    @Test
    public void  test17(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext3.xml");
        Category category=(Category) context.getBean("c");
        System.out.println(category.getName());
    }
}

