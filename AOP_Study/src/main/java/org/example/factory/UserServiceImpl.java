package org.example.factory;

import org.example.proxy.User;

public class UserServiceImpl implements UserService{
    @Override
    public void login(String username, String password) {
        System.out.println("----userService.login-------");
    }

    @Override
    public void register(User user) {
        System.out.println("---------userService.register-----------");
    }
}
