package org.example.aspect;

import org.example.proxy.User;

public interface UserService {
    public void login(String name,String password);
    public void register(User user);
}
