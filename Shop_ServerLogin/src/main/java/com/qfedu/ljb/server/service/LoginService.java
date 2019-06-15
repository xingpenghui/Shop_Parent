package com.qfedu.ljb.server.service;

import com.qfedu.common.vo.R;

/**
 *@Author feri
 *@Date Created in 2019/6/14 14:30
 */
public interface LoginService {
    //实现登录
    R login(String phone,String pass);
    //校验登录有效性
    R checkLogin(String token);
    //注销
    R exitLogin(String token);


}
