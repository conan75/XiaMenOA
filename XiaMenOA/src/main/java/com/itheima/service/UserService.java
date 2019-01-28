package com.itheima.service;

import com.itheima.domain.TbUser;


public interface UserService {
    TbUser checkLogin(String username, String password);

    TbUser findOne(String username);
}
