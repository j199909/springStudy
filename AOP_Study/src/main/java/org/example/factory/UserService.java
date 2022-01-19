package org.example.factory;

import org.example.proxy.User;

public interface UserService {
    public void login(String username,String password);
    public void register(User user);
}
