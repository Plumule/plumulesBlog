package com.lj.service;

import com.lj.po.User;

public interface UserService {
    User checkUser(String username, String password);
}
