package org.example.factorybean;

import org.springframework.beans.factory.FactoryBean;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactoryBean implements FactoryBean<Connection> {
    private String driverClassName;
    private String url;



    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String username;
    private String password;
    //对象
    @Override
    public Connection getObject() throws Exception {
        Class.forName(driverClassName);
        Connection conn= DriverManager.getConnection(url,username,password);
        return conn;
    }
    //对象类型
    @Override
    public Class<?> getObjectType() {
        return Connection.class;
    }
    //返回false:每一次都会创建新的对象
    //返回true:只会创建一次
    //返回哪个要看对象是否能被大家公用 连接对象不能被公用
    @Override
    public boolean isSingleton() {
        return false;
    }
}
