package org.example;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.domain.Student;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MyTest {

    @Test
    public void testSelectStudentById() throws IOException {
        //1.mybatis 主配置文件
        String config = "mybatis.xml";
        //2.读取配置文件
        InputStream inputStream = Resources.getResourceAsStream(config);
        //3.创建 SqlSessionFactory 对象,目的是获取 SqlSession
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session=factory.openSession();
        String sqlId="org.example.dao.StudentDao"+"."+"selectStudentById";
        Student student=session.selectOne(sqlId,1);
        System.out.println(student.getName());

        session.close();
    }
    @Test
    public void testSelectStudentById2() throws IOException {
        //1.mybatis 主配置文件
        String config = "mybatis.xml";
        //2.读取配置文件
        InputStream inputStream = Resources.getResourceAsStream(config);
        //3.创建 SqlSessionFactory 对象,目的是获取 SqlSession
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session=factory.openSession();
        String sqlId="org.example.dao.StudentDao"+"."+"selectStudentById";
        Student student=session.selectOne(sqlId,2);
        System.out.println(student.getName());

        session.close();
    }
    @Test
    public void testInsertStudent() throws IOException {
        //1.mybatis 主配置文件
        String config = "mybatis.xml";
        //2.读取配置文件
        InputStream inputStream = Resources.getResourceAsStream(config);
        //3.创建 SqlSessionFactory 对象,目的是获取 SqlSession
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session=factory.openSession();
        String sqlId="org.example.dao.StudentDao"+"."+"insertStudent";
        Student stu=new Student();
        stu.setId(4);
        stu.setAge(15);
        stu.setEmail("1262@qq.com");
        stu.setName("小明");
        int rows=session.insert(sqlId,stu);
        System.out.println(rows);
        //mybatis手工提交 在insert update需要手工提交
        session.commit();
        session.close();
    }
}
