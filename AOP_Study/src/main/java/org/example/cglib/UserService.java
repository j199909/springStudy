package org.example.cglib;

import org.example.proxy.User;

public class UserService {
    public void login(String name, String password){
        System.out.println("--userService.login");
    }
    public void register(User user){
        System.out.println("userService.register");
    }
}
