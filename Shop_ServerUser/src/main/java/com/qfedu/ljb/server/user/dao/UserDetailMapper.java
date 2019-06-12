package com.qfedu.ljb.server.user.dao;

import com.qfedu.ljb.entity.UserDetail;

public interface UserDetailMapper {
    int insert(UserDetail record);
    int insertInit(int uid);
}