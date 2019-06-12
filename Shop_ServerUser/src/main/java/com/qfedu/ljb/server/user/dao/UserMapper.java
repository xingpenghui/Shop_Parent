package com.qfedu.ljb.server.user.dao;

import com.qfedu.ljb.entity.User;

import java.util.List;

public interface UserMapper {
    int insert(User record);
    List<User> all();
}