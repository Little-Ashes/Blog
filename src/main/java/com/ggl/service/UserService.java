package com.ggl.service;

import com.ggl.domain.User;

public interface UserService {
    public User checkUser(String username, String password);
}
