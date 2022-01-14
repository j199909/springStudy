package org.example.proxy;

/**
 * UserService的代理类
 */
public class UserServiceProxy implements UserService{
    private UserServiceImpl userService=new UserServiceImpl();
    @Override
    public void register(User user) {
        System.out.println("-----log----日志操作");
        userService.register(user);
    }

    @Override
    public boolean login(String name, String password) {
        System.out.println("-----log----日志操作");

        return userService.login(name,password);
    }
}
