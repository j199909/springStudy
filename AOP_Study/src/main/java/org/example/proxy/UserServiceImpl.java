package org.example.proxy;

/**
 * 原始类
 */
public class UserServiceImpl implements  UserService{
    @Override
    public void register(User user) {
        System.out.println("UserServiceImpl.register 业务运算+dao调用");
    }

    @Override
    public boolean login(String name, String password) {
        System.out.println("UserServiceImpl.login 业务运算+dao调用");
        return true;
    }
}
